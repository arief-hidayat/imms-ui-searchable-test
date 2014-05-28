<% import grails.persistence.Event %>
<%=packageName%>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="imms"/>
    <g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div class="row" id="content-section">
    <ul class="nav nav-tabs">
        <li><a href="#list-section" data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span> <g:message code="default.list.label" args="[entityName]" /></a></li>
        <li  class="active"><a href="#detail-section" data-toggle="tab"><span class="glyphicon glyphicon-list-alt"></span> <g:message code="default.detail.label" args="[entityName]" /></a></li>
    </ul>
    <div class="tab-content">
        <div id="list-section" class="tab-pane col-md-12"> %{--App.view.TableRegion--}%
            <div class="row buttons" style="margin-top: 10px">
                <div class="col-md-4 col-centered">
                    <bt:create/>
                    <bt:show/>
                    <bt:delete/>
                </div>
            </div>
            <div class="row">
                <dt:table key='${className}'/>%{-- App.view.Table--}%
            </div>
        </div>
        <div id="detail-section" class="tab-pane active col-md-12">
            <div class="row">
                <g:if test="\${flash.message}">
                    <div class="message" role="status">\${flash.message}</div>
                </g:if>
            </div>
            <div class="row">
                <ul class="property-list ${domainClass.propertyName}">
                    <%  excludedProps = Event.allEvents.toList() << 'id' << 'version'
                    allowedNames = domainClass.persistentProperties*.name << 'dateCreated' << 'lastUpdated'
                    props = domainClass.properties.findAll { allowedNames.contains(it.name) && !excludedProps.contains(it.name) && (domainClass.constrainedProperties[it.name] ? domainClass.constrainedProperties[it.name].display : true) }
                    Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                    props.each { p -> %>
                    <g:if test="\${${propertyName}?.${p.name}}">
                        <li class="fieldcontain">
                            <span id="${p.name}-label" class="property-label"><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></span>
                            <%  if (p.isEnum()) { %>
                            <span class="property-value" aria-labelledby="${p.name}-label"><g:fieldValue bean="\${${propertyName}}" field="${p.name}"/></span>
                            <%  } else if (p.oneToMany || p.manyToMany) { %>
                            <g:each in="\${${propertyName}.${p.name}}" var="${p.name[0]}">
                                <span class="property-value" aria-labelledby="${p.name}-label"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${p.name[0]}.id}">\${${p.name[0]}?.encodeAsHTML()}</g:link></span>
                            </g:each>
                            <%  } else if (p.manyToOne || p.oneToOne) { %>
                            <span class="property-value" aria-labelledby="${p.name}-label"><g:link controller="${p.referencedDomainClass?.propertyName}" action="show" id="\${${propertyName}?.${p.name}?.id}">\${${propertyName}?.${p.name}?.encodeAsHTML()}</g:link></span>
                            <%  } else if (p.type == Boolean || p.type == boolean) { %>
                            <span class="property-value" aria-labelledby="${p.name}-label"><g:formatBoolean boolean="\${${propertyName}?.${p.name}}" /></span>
                            <%  } else if (p.type == Date || p.type == java.sql.Date || p.type == java.sql.Time || p.type == Calendar) { %>
                            <span class="property-value" aria-labelledby="${p.name}-label"><g:formatDate date="\${${propertyName}?.${p.name}}" /></span>
                            <%  } else if (!p.type.isArray()) { %>
                            <span class="property-value" aria-labelledby="${p.name}-label"><g:fieldValue bean="\${${propertyName}}" field="${p.name}"/></span>
                            <%  } %>
                        </li>
                    </g:if>
                    <%  } %>
                </ul>
                <g:form url="[resource:${propertyName}, action:'delete']" method="DELETE">
                    <fieldset class="buttons">
                        <g:actionSubmit class="btn btn-info" action="edit" value="\${message(code: 'default.button.edit.label', default: 'Edit')}"  />
                        <g:actionSubmit class="btn btn-danger" action="delete" value="\${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('\${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8">
    var initMainTable = false;
    App.url = "\${request.contextPath}";
    jQuery(document).ready(function() {
        jQuery("#content-section > .nav-tabs li:eq(2) a").tab('show');
        jQuery("#content-section > .nav-tabs li:first a").click(function(){
            if(!initMainTable) {
                new App.view.TableRegion( {el: '#list-section', key: '${className}'} );
                initMainTable = true;
            }
        });
    } );
</script>
</body>
</html>
