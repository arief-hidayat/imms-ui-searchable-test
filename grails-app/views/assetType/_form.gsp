<%@ page import="com.hida.imms.AssetType" %>



<div class="form-group ${hasErrors(bean: assetTypeInstance, field: 'type', 'has-error')} required">
    <label for="type">
        <g:message code="assetType.type.label" default="Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="form-control" name="type" maxlength="30" required="" value="${assetTypeInstance?.type}"  readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: assetTypeInstance, field: 'note', 'has-error')} ">
    <label for="note">
        <g:message code="assetType.note.label" default="Note"/>

    </label>
    <g:textField class="form-control" name="note" maxlength="76" value="${assetTypeInstance?.note}" />
</div>

