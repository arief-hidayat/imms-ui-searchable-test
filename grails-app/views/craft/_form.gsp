<%@ page import="com.hida.imms.resource.Craft" %>

<div class="col-md-12">
    <div class="row">
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
    </div>
    <div class="row" id="craft-employee-section">
        <div id="list-section" class="col-md-3">
            <div class="row buttons" style="margin-top: 10px">
                <div class="col-md-3 col-centered">
                    <bt:show>&nbsp;</bt:show>
                    <bt:delete>&nbsp;</bt:delete>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="employee">
                        <g:message code="default.add.label" args="['employee']"/>
                    </label>
                    <bs:typeAhead id="employee" domain="Employee" items="all" minLength="1" readonly="${show ?: false}"/>
                </div>
            </div>
            <div class="row">
                <dt:table key='CraftEmployee'/>%{-- App.view.Table--}%
            </div>
        </div>
        <div id="detail-section" class="col-md-9">
            <div class="row buttons" style="margin-top: 20px">
            </div>
            <g:render template="formEmployee"/>
        </div>
    </div>
</div>




