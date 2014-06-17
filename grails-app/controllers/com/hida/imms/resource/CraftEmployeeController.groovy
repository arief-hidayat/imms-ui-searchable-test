package com.hida.imms.resource


import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CraftEmployeeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def createForm() {
        println "inside create form"
        render(model: [craftEmployeeInstance: new CraftEmployee(params)], view: "_partialCreate")
    }

    def editForm(CraftEmployee craftEmployeeInstance) {
        render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialEdit")
    }

    def showForm(CraftEmployee craftEmployeeInstance) {
        render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialShow") //
    }

    def deleteJSON() {
        CraftEmployee craftEmployeeInstance = CraftEmployee.get(params.craftId, params.employeeId)
        if (craftEmployeeInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'craftEmployee.label', default: 'CraftEmployee'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            craftEmployeeInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'craftEmployee.label', default: 'CraftEmployee'), craftEmployeeInstance.id]), params, OK)
            println "deleted successfully"
        } catch (Exception e) {
            log.error("Failed to delete CraftEmployee. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'craftEmployee.label', default: 'CraftEmployee'), craftEmployeeInstance.id]), params, INTERNAL_SERVER_ERROR)
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
        respond new CraftEmployee()
    }

    def show(CraftEmployee craftEmployeeInstance) {
        if (params._partial) {
            render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialShow")
            return
        }
        respond craftEmployeeInstance
    }

    def create() {
        if (params._partial) {
            render(model: [craftEmployeeInstance: new CraftEmployee(params)], view: "_partialCreate")
            return
        }
        respond new CraftEmployee(params)
    }

    @Transactional
    def save(CraftEmployee craftEmployeeInstance) {
        if (craftEmployeeInstance == null) {
            notFound()
            return
        }

        if (craftEmployeeInstance.hasErrors()) {
            if (params._partial) {
                response.status = 412
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialCreate")
                return
            }
            respond craftEmployeeInstance.errors, view: 'create'
            return
        }



        String msg = message(code: 'default.created.message', args: [message(code: 'craftEmployee.label', default: 'CraftEmployee'), craftEmployeeInstance.id])
        try {
            craftEmployeeInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!craftEmployeeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect craftEmployeeInstance
            }
            '*' { respond craftEmployeeInstance, [status: CREATED] }
        }
    }

    def edit(CraftEmployee craftEmployeeInstance) {
        if (params._partial) {
            render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialEdit")
            return
        }
        respond craftEmployeeInstance
    }

    @Transactional
    def update(CraftEmployee craftEmployeeInstance) {
        if (craftEmployeeInstance == null) {
            notFound()
            return
        }

        if (craftEmployeeInstance.hasErrors()) {
            if (params._partial) {
                response.status = 412
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialEdit")
                return
            }
            respond craftEmployeeInstance.errors, view: 'edit'
            return
        }
        String msg = message(code: 'default.updated.message', args: [message(code: 'CraftEmployee.label', default: 'CraftEmployee'), craftEmployeeInstance.id])
        try {
            craftEmployeeInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!craftEmployeeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect craftEmployeeInstance
            }
            '*' { respond craftEmployeeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CraftEmployee craftEmployeeInstance) {

        if (craftEmployeeInstance == null) {
            notFound()
            return
        }

        String msg = message(code: 'default.deleted.message', args: [message(code: 'CraftEmployee.label', default: 'CraftEmployee'), craftEmployeeInstance.id])
        try {
            craftEmployeeInstance.delete flush: true
            if (params._partial) {
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_partialCreate")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!craftEmployeeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [craftEmployeeInstance: craftEmployeeInstance], view: "_message")
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
        String msg = message(code: 'default.not.found.message', args: [message(code: 'craftEmployee.label', default: 'CraftEmployee'), params.id])
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
