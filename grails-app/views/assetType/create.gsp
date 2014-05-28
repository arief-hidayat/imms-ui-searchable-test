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
                <g:hasErrors bean="${assetTypeInstance}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${assetTypeInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                    error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
            </div>

            <div class="row">
                <g:form url="[resource: assetTypeInstance, action: 'save']">
                    <fieldset class="form">
                        <g:render template="form"/>
                    </fieldset>
                    <fieldset class="buttons">
                        <g:submitButton name="create" class="btn btn-success"
                                        value="${message(code: 'default.button.create.label', default: 'Create')}"/>
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
