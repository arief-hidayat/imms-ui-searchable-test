<%@ page import="com.hida.imms.Asset" %>

<div class="row">
    <div class="col-md-4">
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'code', 'has-error')} required">
            <label for="code">
                <g:message code="asset.code.label" default="Code"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="code" maxlength="50" required="" value="${assetInstance?.code}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'name', 'has-error')} required">
            <label for="name">
                <g:message code="asset.name.label" default="Name"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="name" maxlength="150" required="" value="${assetInstance?.name}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'assetType', 'has-error')} required">
            <label for="assetType">
                <g:message code="asset.assetType.label" default="Asset Type"/>
                <span class="required-indicator">*</span>
            </label>
            <bs:typeAhead id="assetType" parentInstance="assetInstance" field="assetType" domain="AssetType" items="all" minLength="1"  value="${assetInstance?.assetType}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'assetGroup', 'has-error')} ">
            <label for="assetGroup">
                <g:message code="asset.assetGroup.label" default="Asset Group"/>
            </label>
            <bs:typeAhead id="assetGroup" parentInstance="assetInstance" field="assetGroup" domain="AssetGroup" items="all" minLength="1"  value="${assetInstance?.assetGroup}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'modelNo', 'has-error')} required">
            <label for="modelNo">
                <g:message code="asset.modelNo.label" default="Model No"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="modelNo" value="${assetInstance?.modelNo}"/>
        </div>

        <div class="form-group ${hasErrors(bean: assetInstance, field: 'serialNo', 'has-error')} required">
            <label for="serialNo">
                <g:message code="asset.serialNo.label" default="Serial No"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="serialNo" value="${assetInstance?.serialNo}"/>
        </div>

        <div class="form-group ${hasErrors(bean: assetInstance, field: 'manufacturer', 'has-error')} required">
            <label for="manufacturer">
                <g:message code="asset.manufacturer.label" default="Manufacturer"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="manufacturer" value="${assetInstance?.manufacturer}"/>
        </div>
    </div>
    <div class="col-md-4">
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'purchaseDate', 'has-error')} required">
            <label for="purchaseDate">
                <g:message code="asset.purchaseDate.label" default="Purchase Date"/>
                <span class="required-indicator">*</span>
            </label>
            <bs:datePicker id="assetInstance-purchaseDate" field="purchaseDate"
                           value="${assetInstance?.purchaseDate}"></bs:datePicker>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'vendorCd', 'has-error')} required">
            <label for="vendorCd">
                <g:message code="asset.vendorCd.label" default="Vendor Cd"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="vendorCd" value="${assetInstance?.vendorCd}"/>
        </div>

        <div class="form-group ${hasErrors(bean: assetInstance, field: 'baseDate', 'has-error')} required">
            <label for="assetInstance-baseDate">
                <g:message code="asset.baseDate.label" default="Base Date"/>
                <span class="required-indicator">*</span>
            </label>
            <bs:datePicker id="assetInstance-baseDate" field="baseDate" value="${assetInstance?.baseDate}"></bs:datePicker>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'warrantyStartDate', 'has-error')} required">
            <label for="warrantyStartDate">
                <g:message code="asset.warrantyStartDate.label" default="Warranty Start Date"/>
                <span class="required-indicator">*</span>
            </label>
            <bs:datePicker id="assetInstance-warrantyStartDate" field="warrantyStartDate"
                           value="${assetInstance?.warrantyStartDate}"></bs:datePicker>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'warrantyEndDate', 'has-error')} required">
            <label for="warrantyEndDate">
                <g:message code="asset.warrantyEndDate.label" default="Warranty End Date"/>
                <span class="required-indicator">*</span>
            </label>
            <bs:datePicker id="assetInstance-warrantyEndDate" field="warrantyEndDate"
                           value="${assetInstance?.warrantyEndDate}"></bs:datePicker>
        </div>

        <div class="form-group ${hasErrors(bean: assetInstance, field: 'depreciationInterval', 'has-error')} required">
            <label for="depreciationInterval">
                <g:message code="asset.depreciationInterval.label" default="Depreciation Interval"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="depreciationInterval" value="${assetInstance?.depreciationInterval}"/>
        </div>

        <div class="form-group ${hasErrors(bean: assetInstance, field: 'depreciationType', 'has-error')} required">
            <label for="depreciationType">
                <g:message code="asset.depreciationType.label" default="Depreciation Type"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="depreciationType" value="${assetInstance?.depreciationType}"/>
        </div>
        %{--<div class="form-group ${hasErrors(bean: assetInstance, field: 'originalCost', 'has-error')} required">--}%
            %{--<label for="originalCost">--}%
                %{--<g:message code="asset.originalCost.label" default="Original Cost"/>--}%
                %{--<span class="required-indicator">*</span>--}%
            %{--</label>--}%
            %{--<g:field type="number" class="form-control" name="originalCost" min="0" required=""--}%
                     %{--value="${fieldValue(bean: assetInstance, field: 'originalCost')}"/>--}%
        %{--</div>--}%
        %{--<div class="form-group ${hasErrors(bean: assetInstance, field: 'originalCostUnit', 'has-error')} required">--}%
            %{--<label for="originalCostUnit">--}%
                %{--<g:message code="asset.originalCostUnit.label" default="Original Cost Unit"/>--}%
                %{--<span class="required-indicator">*</span>--}%
            %{--</label>--}%
            %{--<g:textField class="form-control" name="originalCostUnit" value="${assetInstance?.originalCostUnit}"/>--}%
        %{--</div>--}%
    </div>

    <div class="col-md-4">
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'status', 'has-error')} required">
            <label for="status">
                <g:message code="asset.status.label" default="Status"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="status" value="${assetInstance?.status}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'priority', 'has-error')} required">
            <label for="priority">
                <g:message code="asset.priority.label" default="Priority"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="priority" value="${assetInstance?.priority}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'locationCd', 'has-error')} required">
            <label for="locationCd">
                <g:message code="asset.locationCd.label" default="Location Cd"/>
                <span class="required-indicator">*</span>
            </label>
            <g:textField class="form-control" name="locationCd" value="${assetInstance?.locationCd}"/>
        </div>
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'parentCd', 'has-error')} ">
            <label for="parentCd">
                <g:message code="asset.parentCd.label" default="Parent Cd"/>

            </label>
            <g:textField class="form-control" name="parentCd" value="${assetInstance?.parentCd}"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="form-group ${hasErrors(bean: assetInstance, field: 'note', 'has-error')} ">
            <label for="note">
                <g:message code="asset.note.label" default="Note"/>
            </label>
            <g:textField class="form-control" name="note" value="${assetInstance?.note}"/>
        </div>

        <div class="form-group ${hasErrors(bean: assetInstance, field: 'description', 'has-error')} ">
            <label for="description">
                <g:message code="asset.description.label" default="Description"/>

            </label>
            <g:textArea class="form-control" name="description" cols="40" rows="5" maxlength="1000"
                        value="${assetInstance?.description}"/>
        </div>
    </div>
</div>
















