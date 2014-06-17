<%@ page import="com.hida.imms.resource.Craft" %>



<div class="form-group ${hasErrors(bean: craftInstance, field: 'craft', 'has-error')} required">
	<label for="craft">
		<g:message code="craft.craft.label" default="Craft" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="craft" maxlength="50" required="" value="${craftInstance?.craft}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: craftInstance, field: 'note', 'has-error')} ">
	<label for="note">
		<g:message code="craft.note.label" default="Note" />
		
	</label>
	<g:textField class="form-control" name="note" maxlength="76" value="${craftInstance?.note}" readonly="${show ?: false}"/>
</div>

