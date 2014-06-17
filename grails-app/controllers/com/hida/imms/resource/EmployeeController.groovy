package com.hida.imms.resource


import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmployeeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def createForm() {
        println "inside create form"
        render(model: [employeeInstance: new Employee(params)], view: "_partialCreate")
    }

    def editForm(Employee employeeInstance) {
        render(model: [employeeInstance: employeeInstance], view: "_partialEdit")
    }

    def showForm(Employee employeeInstance) {
        render(model: [employeeInstance: employeeInstance], view: "_partialShow") //
    }

    def deleteJSON() {
        Employee employeeInstance = Employee.get(params.id)
        if (employeeInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            employeeInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'employee.label', default: 'Employee'), employeeInstance.id]), params, OK)
            println "deleted successfully"
        } catch (Exception e) {
            log.error("Failed to delete Employee. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'employee.label', default: 'Employee'), employeeInstance.id]), params, INTERNAL_SERVER_ERROR)
            println "item couldn't be deleted"
        }
    }

    private def renderJsonMessage(String msg, def parameter, HttpStatus status) {
        render(status: status, contentType: "application/json;  charset=utf-8") {
            [message: msg, params: parameter]
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond new Employee()
    }

    def show(Employee employeeInstance) {
        if (params._partial) {
            render(model: [employeeInstance: employeeInstance], view: "_partialShow")
            return
        }
        respond employeeInstance
    }

    def create() {
        if (params._partial) {
            render(model: [employeeInstance: new Employee(params)], view: "_partialCreate")
            return
        }
        respond new Employee(params)
    }

    @Transactional
    def save(Employee employeeInstance) {
        if (employeeInstance == null) {
            notFound()
            return
        }

        if (employeeInstance.hasErrors()) {
            if (params._partial) {
                response.status = 412
                render(model: [employeeInstance: employeeInstance], view: "_partialCreate")
                return
            }
            respond employeeInstance.errors, view: 'create'
            return
        }



        String msg = message(code: 'default.created.message', args: [message(code: 'employee.label', default: 'Employee'), employeeInstance.id])
        try {
            employeeInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [employeeInstance: employeeInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!employeeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [employeeInstance: employeeInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect employeeInstance
            }
            '*' { respond employeeInstance, [status: CREATED] }
        }
    }

    def edit(Employee employeeInstance) {
        if (params._partial) {
            render(model: [employeeInstance: employeeInstance], view: "_partialEdit")
            return
        }
        respond employeeInstance
    }

    @Transactional
    def update(Employee employeeInstance) {
        if (employeeInstance == null) {
            notFound()
            return
        }

        if (employeeInstance.hasErrors()) {
            if (params._partial) {
                response.status = 412
                render(model: [employeeInstance: employeeInstance], view: "_partialEdit")
                return
            }
            respond employeeInstance.errors, view: 'edit'
            return
        }
        String msg = message(code: 'default.updated.message', args: [message(code: 'Employee.label', default: 'Employee'), employeeInstance.id])
        try {
            employeeInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [employeeInstance: employeeInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!employeeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [employeeInstance: employeeInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect employeeInstance
            }
            '*' { respond employeeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Employee employeeInstance) {

        if (employeeInstance == null) {
            notFound()
            return
        }

        String msg = message(code: 'default.deleted.message', args: [message(code: 'Employee.label', default: 'Employee'), employeeInstance.id])
        try {
            employeeInstance.delete flush: true
            if (params._partial) {
                render(model: [employeeInstance: employeeInstance], view: "_partialCreate")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!employeeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [employeeInstance: employeeInstance], view: "_message")
                return
            }
        }
        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        String msg = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), params.id])
        if (params._partial) {
            render(status: NOT_FOUND, text: msg)
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
