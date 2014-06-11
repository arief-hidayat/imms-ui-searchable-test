package com.hida.imms

import grails.plugin.jodatime.Html5DateTimeFormat
import grails.util.Holders
import org.grails.databinding.converters.ValueConverter
import org.joda.time.*
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.context.i18n.LocaleContextHolder

class JodaDateConverter implements ValueConverter {

    static final SUPPORTED_TYPES = [LocalTime, LocalDate, LocalDateTime, DateTime, Instant].asImmutable()


    Class<?> type

    @Lazy private ConfigObject config = Holders.config?.jodatime?.format

    @Override
    public boolean canConvert(Object value) {
        println "canConvert"
        return value instanceof String
    }

    @Override
    public Object convert(Object value) {
        println "type: $type"
        println "formatter: $formatter"
        value ? formatter.parseDateTime(value)."to$type.simpleName"() : null
    }

    @Override
    public Class<?> getTargetType() {
        "targetType: $type"
        return type;
    }


    protected DateTimeFormatter getFormatter() {
        if (hasConfigPatternFor(type)) {
            println "Pattern ${getConfigPatternFor(type)}"
            return DateTimeFormat.forPattern(getConfigPatternFor(type))
        } else if (useISO()) {
            println "ISO: ${getISOFormatterFor(type)}"
            return getISOFormatterFor(type)
        } else {
            def style
            switch (type) {
                case LocalTime:
                    style = '-S'
                    break
                case LocalDate:
                    style = 'S-'
                    break
                default:
                    style = 'SS'
            }
            Locale locale = LocaleContextHolder.locale
            return DateTimeFormat.forStyle(style).withLocale(locale)
        }
    }

    private boolean hasConfigPatternFor(Class type) {
        config?.flatten()?."$type.name"
    }

    private String getConfigPatternFor(Class type) {
        config?.flatten()?."$type.name"
    }

    private boolean useISO() {
        config?.html5
    }

    private DateTimeFormatter getISOFormatterFor(Class type) {
        switch (type) {
            case LocalTime:
                return Html5DateTimeFormat.time()
            case LocalDate:
                return Html5DateTimeFormat.date()
            case LocalDateTime:
                return Html5DateTimeFormat.datetimeLocal()
            case DateTime:
            case Instant:
                return Html5DateTimeFormat.datetime()
        }
        return null
    }


}