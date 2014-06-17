package com.hida.imms

import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
import org.codehaus.groovy.grails.orm.hibernate.cfg.CompositeIdentity

class DomainClassUtil {
    def getPrimaryKey(DefaultGrailsDomainClass domainClass) {
        def identity = (domainClass.hasProperty('mapping') ? domainClass.clazz.mapping?.getMapping()?.getIdentity():null)
        identity instanceof CompositeIdentity ?  identity.getPropertyNames() : ["id"]
    }
}
