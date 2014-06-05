<div class="row">
    <g:render template="message"/>
</div>

<div class="row">
    <g:form id="AssetType-create-form" url="[resource: assetTypeInstance, action: 'save']">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="btn btn-success"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>