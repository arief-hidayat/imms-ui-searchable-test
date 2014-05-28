<%@ page import="com.hida.imms.AssetType" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="imms"/>
    <g:set var="entityName" value="${message(code: 'assetType.label', default: 'AssetType')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="row" id="content-section">
    <ul class="nav nav-tabs">
        <li><a href="#list-section" data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span> <g:message
                code="default.list.label" args="[entityName]"/></a></li>
        <li class="active"><a href="#detail-section" data-toggle="tab"><span
                class="glyphicon glyphicon-list-alt"></span> <g:message code="default.detail.label"
                                                                        args="[entityName]"/></a></li>
    </ul>

    <div class="tab-content">
        <div id="list-section" class="tab-pane col-md-12">%{--App.view.TableRegion--}%
            <div class="row buttons" style="margin-top: 10px">
                <div class="col-md-4 col-centered">
                    <bt:create/>
                    <bt:show/>
                    <bt:delete/>
                </div>
            </div>

            <div class="row">
                <dt:table key='AssetType'/>%{-- App.view.Table--}%
            </div>
        </div>

        <div id="detail-section" class="tab-pane active col-md-12">
            <div class="row">
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
            </div>

            <div class="row">
                <ul class="property-list assetType">

                    <g:if test="${assetTypeInstance?.type}">
                        <li class="fieldcontain">
                            <span id="type-label" class="property-label"><g:message code="assetType.type.label"
                                                                                    default="Type"/></span>

                            <span class="property-value" aria-labelledby="type-label"><g:fieldValue
                                    bean="${assetTypeInstance}" field="type"/></span>

                        </li>
                    </g:if>

                    <g:if test="${assetTypeInstance?.note}">
                        <li class="fieldcontain">
                            <span id="note-label" class="property-label"><g:message code="assetType.note.label"
                                                                                    default="Note"/></span>

                            <span class="property-value" aria-labelledby="note-label"><g:fieldValue
                                    bean="${assetTypeInstance}" field="note"/></span>

                        </li>
                    </g:if>

                </ul>
                <g:form url="[resource: assetTypeInstance, action: 'delete']" method="DELETE">
                    <fieldset class="buttons">
                        <g:actionSubmit class="btn btn-info" action="edit"
                                        value="${message(code: 'default.button.edit.label', default: 'Edit')}"/>
                        <g:actionSubmit class="btn btn-danger" action="delete"
                                        value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                        onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
                    </fieldset>
                </g:form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8">
    var initMainTable = false;
    App.url = "${request.contextPath}";
    jQuery(document).ready(function () {
        jQuery("#content-section > .nav-tabs li:eq(2) a").tab('show');
        jQuery("#content-section > .nav-tabs li:first a").click(function () {
            if (!initMainTable) {
                new App.view.TableRegion({el: '#list-section', key: 'AssetType'});
                initMainTable = true;
            }
        });
    });
</script>
</body>
</html>
