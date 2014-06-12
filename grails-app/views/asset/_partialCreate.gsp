<div class="row message-container">
    <g:render template="message"/>
</div>

<div class="row">
    <g:form id="Asset-create-form" url="[resource: assetInstance, action: 'save']">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="btn btn-success"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>