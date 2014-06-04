<div class="row">
    <g:render template="message"/>
</div>
<div class="row">
    <g:form id="Asset-edit-form" url="[resource: assetInstance, action: 'update']" method="PUT">
        <g:hiddenField name="version" value="${assetInstance?.version}"/>
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <g:actionSubmit class="btn btn-success" action="update"
                            value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>