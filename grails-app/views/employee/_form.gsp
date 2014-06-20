<%@ page import="com.hida.imms.resource.Employee" %>



<div class="form-group ${hasErrors(bean: employeeInstance, field: 'code', 'has-error')} required">
	<label for="code">
		<g:message code="employee.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="code" maxlength="20" required="" value="${employeeInstance?.code}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'firstName', 'has-error')} required">
	<label for="firstName">
		<g:message code="employee.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="firstName" maxlength="50" required="" value="${employeeInstance?.firstName}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'lastName', 'has-error')} ">
	<label for="lastName">
		<g:message code="employee.lastName.label" default="Last Name" />
		
	</label>
	<g:textField class="form-control" name="lastName" maxlength="50" value="${employeeInstance?.lastName}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'jobTitle', 'has-error')} required">
	<label for="jobTitle">
		<g:message code="employee.jobTitle.label" default="Job Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="jobTitle" maxlength="30" value="${employeeInstance?.jobTitle}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'departmentCd', 'has-error')} ">
	<label for="departmentCd">
		<g:message code="employee.departmentCd.label" default="Department Cd" />
		
	</label>
	<g:textField class="form-control" name="departmentCd" value="${employeeInstance?.departmentCd}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'note', 'has-error')} ">
	<label for="note">
		<g:message code="employee.note.label" default="Note" />
		
	</label>
	<g:textField class="form-control" name="note" maxlength="76" value="${employeeInstance?.note}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'officePhone', 'has-error')} ">
	<label for="officePhone">
		<g:message code="employee.officePhone.label" default="Office Phone" />
		
	</label>
	<g:textField class="form-control" name="officePhone" maxlength="24" value="${employeeInstance?.officePhone}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'homePhone', 'has-error')} ">
	<label for="homePhone">
		<g:message code="employee.homePhone.label" default="Home Phone" />
		
	</label>
	<g:textField class="form-control" name="homePhone" maxlength="16" value="${employeeInstance?.homePhone}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'mobilePhone', 'has-error')} ">
	<label for="mobilePhone">
		<g:message code="employee.mobilePhone.label" default="Mobile Phone" />
		
	</label>
	<g:textField class="form-control" name="mobilePhone" maxlength="16" value="${employeeInstance?.mobilePhone}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'officeEmail', 'has-error')} ">
	<label for="officeEmail">
		<g:message code="employee.officeEmail.label" default="Office Email" />
		
	</label>
	<g:field type="email" class="form-control" name="officeEmail" maxlength="50" value="${employeeInstance?.officeEmail}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'otherEmail', 'has-error')} ">
	<label for="otherEmail">
		<g:message code="employee.otherEmail.label" default="Other Email" />
		
	</label>
	<g:field type="email" class="form-control" name="otherEmail" maxlength="50" value="${employeeInstance?.otherEmail}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'faxNumber', 'has-error')} ">
	<label for="faxNumber">
		<g:message code="employee.faxNumber.label" default="Fax Number" />
		
	</label>
	<g:textField class="form-control" name="faxNumber" maxlength="16" value="${employeeInstance?.faxNumber}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'addressLine1', 'has-error')} ">
	<label for="addressLine1">
		<g:message code="employee.addressLine1.label" default="Address Line1" />
		
	</label>
	<g:textField class="form-control" name="addressLine1" maxlength="50" value="${employeeInstance?.addressLine1}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'addressLine2', 'has-error')} ">
	<label for="addressLine2">
		<g:message code="employee.addressLine2.label" default="Address Line2" />
		
	</label>
	<g:textField class="form-control" name="addressLine2" maxlength="50" value="${employeeInstance?.addressLine2}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'city', 'has-error')} ">
	<label for="city">
		<g:message code="employee.city.label" default="City" />
		
	</label>
	<g:textField class="form-control" name="city" maxlength="50" value="${employeeInstance?.city}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'state', 'has-error')} ">
	<label for="state">
		<g:message code="employee.state.label" default="State" />
		
	</label>
	<g:textField class="form-control" name="state" maxlength="50" value="${employeeInstance?.state}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'zip', 'has-error')} ">
	<label for="zip">
		<g:message code="employee.zip.label" default="Zip" />
		
	</label>
	<g:textField class="form-control" name="zip" maxlength="16" value="${employeeInstance?.zip}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'country', 'has-error')} ">
	<label for="country">
		<g:message code="employee.country.label" default="Country" />
		
	</label>
	<g:textField class="form-control" name="country" maxlength="50" value="${employeeInstance?.country}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeInstance, field: 'employeeTypeCd', 'has-error')} required">
	<label for="employeeTypeCd">
		<g:message code="employee.employeeTypeCd.label" default="Employee Type Cd" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="employeeTypeCd" value="${employeeInstance?.employeeTypeCd}" readonly="${show ?: false}"/>
</div>

