package com.hida.imms.resource




import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CraftController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def createForm() {
        println "inside create form"
        render(model: [craftInstance: new Craft(params)], view: "_partialCreate")
    }
    def editForm(Craft craftInstance) {
        render(model: [craftInstance: craftInstance], view: "_partialEdit")
    }
    def showForm(Craft craftInstance) {
        render(model: [craftInstance: craftInstance], view: "_partialShow") //
    }

    def deleteJSON() {
        Craft craftInstance = Craft.get(params.id)
        if(craftInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'craft.label', default: 'Craft'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            craftInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'craft.label', default: 'Craft'), craftInstance.id]), params, OK)
            println "deleted successfully"
        } catch(Exception e) {
            log.error("Failed to delete Craft. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'craft.label', default: 'Craft'), craftInstance.id]), params, INTERNAL_SERVER_ERROR)
            println "item couldn't be deleted"
        }
    }

    private def renderJsonMessage(String msg, def parameter, HttpStatus status) {
        render(status: status, contentType: "application/json;  charset=utf-8") {
            [message : msg, params : parameter]
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond new Craft()
    }

    def show(Craft craftInstance) {
        if(params._partial) {
            render(model: [craftInstance: craftInstance], view: "_partialShow")
            return
        }
        respond craftInstance
    }

    def create() {
        if(params._partial) {
            render(model: [craftInstance: new Craft(params)], view: "_partialCreate")
            return
        }
        respond new Craft(params)
    }

    @Transactional
    def save(Craft craftInstance) {
        if (craftInstance == null) {
            notFound()
            return
        }

        if (craftInstance.hasErrors()) {
            if(params._partial) {
                response.status = 412
                render(model: [craftInstance: craftInstance], view: "_partialCreate")
                return
            }
            respond craftInstance.errors, view:'create'
            return
        }



        String msg = message(code: 'default.created.message', args: [message(code: 'craft.label', default: 'Craft'), craftInstance.id])
        try {
            craftInstance.save flush:true, failOnError: true
            if(params._partial) {
                render(model: [craftInstance: craftInstance], view: "_partialShow")
                return
            }
        } catch(Exception e) {
            if(params._partial) {
                response.status = 500
                if (!craftInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [craftInstance: craftInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect craftInstance
            }
            '*' { respond craftInstance, [status: CREATED] }
        }
    }

    def edit(Craft craftInstance) {
        if(params._partial) {
            render(model: [craftInstance: craftInstance], view: "_partialEdit")
            return
        }
        respond craftInstance
    }

    @Transactional
    def update(Craft craftInstance) {
        if (craftInstance == null) {
            notFound()
            return
        }

        if (craftInstance.hasErrors()) {
            if(params._partial) {
                response.status = 412
                render(model: [craftInstance: craftInstance], view: "_partialEdit")
                return
            }
            respond craftInstance.errors, view:'edit'
            return
        }
        String msg = message(code: 'default.updated.message', args: [message(code: 'Craft.label', default: 'Craft'), craftInstance.id])
        try {
            craftInstance.save flush:true, failOnError: true
            if(params._partial) {
                render(model: [craftInstance: craftInstance], view: "_partialShow")
                return
            }
        } catch(Exception e) {
            if(params._partial) {
                response.status = 500
                if (!craftInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [craftInstance: craftInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect craftInstance
            }
            '*'{ respond craftInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Craft craftInstance) {

        if (craftInstance == null) {
            notFound()
            return
        }

        String msg = message(code: 'default.deleted.message', args: [message(code: 'Craft.label', default: 'Craft'), craftInstance.id])
        try {
            craftInstance.delete flush:true
            if(params._partial) {
                render(model: [craftInstance: craftInstance], view: "_partialCreate")
                return
            }
        } catch(Exception e) {
            if(params._partial) {
                response.status = 500
                if (!craftInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [craftInstance: craftInstance], view: "_message")
                return
            }
        }
        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        String msg = message(code: 'default.not.found.message', args: [message(code: 'craft.label', default: 'Craft'), params.id])
        if(params._partial) {
            render(status: NOT_FOUND, text: msg)
            return
        }
        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
