<%@ page import="com.hida.imms.Asset" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="imms"/>
    <g:set var="entityName" value="${message(code: 'asset.label', default: 'Asset')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="row" id="content-section">
<ul class="nav nav-tabs">
    <li><a href="#list-section" data-toggle="tab"><span class="glyphicon glyphicon-th-list"></span> <g:message
            code="default.list.label" args="[entityName]"/></a></li>
    <li class="active"><a href="#detail-section" data-toggle="tab"><span
            class="glyphicon glyphicon-list-alt"></span> <g:message code="default.detail.label" args="[entityName]"/>
    </a></li>
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
        <dt:table key='Asset'/>%{-- App.view.Table--}%
    </div>
</div>

<div id="detail-section" class="tab-pane active col-md-12">
<div class="row">
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
</div>

<div class="row">
<ul class="property-list asset">

    <g:if test="${assetInstance?.code}">
        <li class="fieldcontain">
            <span id="code-label" class="property-label"><g:message code="asset.code.label" default="Code"/></span>

            <span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${assetInstance}"
                                                                                    field="code"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.name}">
        <li class="fieldcontain">
            <span id="name-label" class="property-label"><g:message code="asset.name.label" default="Name"/></span>

            <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${assetInstance}"
                                                                                    field="name"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.assetGroup}">
        <li class="fieldcontain">
            <span id="assetGroup-label" class="property-label"><g:message code="asset.assetGroup.label"
                                                                          default="Asset Group"/></span>

            <span class="property-value" aria-labelledby="assetGroup-label"><g:fieldValue bean="${assetInstance}"
                                                                                          field="assetGroup"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.locationCd}">
        <li class="fieldcontain">
            <span id="locationCd-label" class="property-label"><g:message code="asset.locationCd.label"
                                                                          default="Location Cd"/></span>

            <span class="property-value" aria-labelledby="locationCd-label"><g:fieldValue bean="${assetInstance}"
                                                                                          field="locationCd"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.originalCost}">
        <li class="fieldcontain">
            <span id="originalCost-label" class="property-label"><g:message code="asset.originalCost.label"
                                                                            default="Original Cost"/></span>

            <span class="property-value" aria-labelledby="originalCost-label"><g:fieldValue bean="${assetInstance}"
                                                                                            field="originalCost"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.note}">
        <li class="fieldcontain">
            <span id="note-label" class="property-label"><g:message code="asset.note.label" default="Note"/></span>

            <span class="property-value" aria-labelledby="note-label"><g:fieldValue bean="${assetInstance}"
                                                                                    field="note"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.description}">
        <li class="fieldcontain">
            <span id="description-label" class="property-label"><g:message code="asset.description.label"
                                                                           default="Description"/></span>

            <span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${assetInstance}"
                                                                                           field="description"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.parentCd}">
        <li class="fieldcontain">
            <span id="parentCd-label" class="property-label"><g:message code="asset.parentCd.label"
                                                                        default="Parent Cd"/></span>

            <span class="property-value" aria-labelledby="parentCd-label"><g:fieldValue bean="${assetInstance}"
                                                                                        field="parentCd"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.assetType}">
        <li class="fieldcontain">
            <span id="assetType-label" class="property-label"><g:message code="asset.assetType.label"
                                                                         default="Asset Type"/></span>

            <span class="property-value" aria-labelledby="assetType-label"><g:fieldValue bean="${assetInstance}"
                                                                                         field="assetType"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.baseDate}">
        <li class="fieldcontain">
            <span id="baseDate-label" class="property-label"><g:message code="asset.baseDate.label"
                                                                        default="Base Date"/></span>

            <span class="property-value" aria-labelledby="baseDate-label"><g:fieldValue bean="${assetInstance}"
                                                                                        field="baseDate"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.depreciationInterval}">
        <li class="fieldcontain">
            <span id="depreciationInterval-label" class="property-label"><g:message
                    code="asset.depreciationInterval.label" default="Depreciation Interval"/></span>

            <span class="property-value" aria-labelledby="depreciationInterval-label"><g:fieldValue
                    bean="${assetInstance}" field="depreciationInterval"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.depreciationType}">
        <li class="fieldcontain">
            <span id="depreciationType-label" class="property-label"><g:message code="asset.depreciationType.label"
                                                                                default="Depreciation Type"/></span>

            <span class="property-value" aria-labelledby="depreciationType-label"><g:fieldValue bean="${assetInstance}"
                                                                                                field="depreciationType"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.manufacturer}">
        <li class="fieldcontain">
            <span id="manufacturer-label" class="property-label"><g:message code="asset.manufacturer.label"
                                                                            default="Manufacturer"/></span>

            <span class="property-value" aria-labelledby="manufacturer-label"><g:fieldValue bean="${assetInstance}"
                                                                                            field="manufacturer"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.modelNo}">
        <li class="fieldcontain">
            <span id="modelNo-label" class="property-label"><g:message code="asset.modelNo.label"
                                                                       default="Model No"/></span>

            <span class="property-value" aria-labelledby="modelNo-label"><g:fieldValue bean="${assetInstance}"
                                                                                       field="modelNo"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.originalCostUnit}">
        <li class="fieldcontain">
            <span id="originalCostUnit-label" class="property-label"><g:message code="asset.originalCostUnit.label"
                                                                                default="Original Cost Unit"/></span>

            <span class="property-value" aria-labelledby="originalCostUnit-label"><g:fieldValue bean="${assetInstance}"
                                                                                                field="originalCostUnit"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.priority}">
        <li class="fieldcontain">
            <span id="priority-label" class="property-label"><g:message code="asset.priority.label"
                                                                        default="Priority"/></span>

            <span class="property-value" aria-labelledby="priority-label"><g:fieldValue bean="${assetInstance}"
                                                                                        field="priority"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.purchaseDate}">
        <li class="fieldcontain">
            <span id="purchaseDate-label" class="property-label"><g:message code="asset.purchaseDate.label"
                                                                            default="Purchase Date"/></span>

            <span class="property-value" aria-labelledby="purchaseDate-label"><g:fieldValue bean="${assetInstance}"
                                                                                            field="purchaseDate"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.serialNo}">
        <li class="fieldcontain">
            <span id="serialNo-label" class="property-label"><g:message code="asset.serialNo.label"
                                                                        default="Serial No"/></span>

            <span class="property-value" aria-labelledby="serialNo-label"><g:fieldValue bean="${assetInstance}"
                                                                                        field="serialNo"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.status}">
        <li class="fieldcontain">
            <span id="status-label" class="property-label"><g:message code="asset.status.label"
                                                                      default="Status"/></span>

            <span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${assetInstance}"
                                                                                      field="status"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.vendorCd}">
        <li class="fieldcontain">
            <span id="vendorCd-label" class="property-label"><g:message code="asset.vendorCd.label"
                                                                        default="Vendor Cd"/></span>

            <span class="property-value" aria-labelledby="vendorCd-label"><g:fieldValue bean="${assetInstance}"
                                                                                        field="vendorCd"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.warrantyEndDate}">
        <li class="fieldcontain">
            <span id="warrantyEndDate-label" class="property-label"><g:message code="asset.warrantyEndDate.label"
                                                                               default="Warranty End Date"/></span>

            <span class="property-value" aria-labelledby="warrantyEndDate-label"><g:fieldValue bean="${assetInstance}"
                                                                                               field="warrantyEndDate"/></span>

        </li>
    </g:if>

    <g:if test="${assetInstance?.warrantyStartDate}">
        <li class="fieldcontain">
            <span id="warrantyStartDate-label" class="property-label"><g:message code="asset.warrantyStartDate.label"
                                                                                 default="Warranty Start Date"/></span>

            <span class="property-value" aria-labelledby="warrantyStartDate-label"><g:fieldValue bean="${assetInstance}"
                                                                                                 field="warrantyStartDate"/></span>

        </li>
    </g:if>

</ul>
<g:form url="[resource: assetInstance, action: 'delete']" method="DELETE">
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
        jQuery("#content-section > .nav-tabs li:eq(1) a").tab('show');
        jQuery("#content-section > .nav-tabs li:eq(0) a").click(function () {
            if (!initMainTable) {
                new App.view.TableRegion({el: '#list-section', key: 'Asset'});
                initMainTable = true;
            }
        });
    });
</script>
</body>
</html>
