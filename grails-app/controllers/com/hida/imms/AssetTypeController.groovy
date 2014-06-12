package com.hida.imms


import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AssetTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def createForm() {
        println "inside create form"
        render(model: [assetTypeInstance: new AssetType(params)], view: "_partialCreate")
    }

    def editForm(AssetType assetTypeInstance) {
        render(model: [assetTypeInstance: assetTypeInstance], view: "_partialEdit")
    }

    def showForm(AssetType assetTypeInstance) {
        render(model: [assetTypeInstance: assetTypeInstance], view: "_partialShow") //
    }

    def deleteJSON() {
        AssetType assetTypeInstance = AssetType.get(params.id)
        if (assetTypeInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'assetType.label', default: 'AssetType'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            assetTypeInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'assetType.label', default: 'AssetType'), assetTypeInstance.id]), params, OK)
            println "deleted successfully"
        } catch (Exception e) {
            log.error("Failed to delete AssetType. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'assetType.label', default: 'AssetType'), assetTypeInstance.id]), params, INTERNAL_SERVER_ERROR)
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
        respond new AssetType()
    }

    def show(AssetType assetTypeInstance) {
        if (params._partial) {
            render(model: [assetTypeInstance: assetTypeInstance], view: "_partialShow")
            return
        }
        respond assetTypeInstance
    }

    def create() {
        if (params._partial) {
            render(model: [assetTypeInstance: new AssetType(params)], view: "_partialCreate")
            return
        }
        respond new AssetType(params)
    }

    @Transactional
    def save(AssetType assetTypeInstance) {
        if (assetTypeInstance == null) {
            notFound()
            return
        }

        if (assetTypeInstance.hasErrors()) {
            if (params._partial) {
                render(model: [assetTypeInstance: assetTypeInstance], view: "_partialCreate")
                return
            }
            respond assetTypeInstance.errors, view: 'create'
            return
        }



        String msg = message(code: 'default.created.message', args: [message(code: 'assetType.label', default: 'AssetType'), assetTypeInstance.id])
        try {
            assetTypeInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [assetTypeInstance: assetTypeInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!assetTypeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [assetTypeInstance: assetTypeInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect assetTypeInstance
            }
            '*' { respond assetTypeInstance, [status: CREATED] }
        }
    }

    def edit(AssetType assetTypeInstance) {
        if (params._partial) {
            render(model: [assetTypeInstance: assetTypeInstance], view: "_partialEdit")
            return
        }
        respond assetTypeInstance
    }

    @Transactional
    def update(AssetType assetTypeInstance) {
        if (assetTypeInstance == null) {
            notFound()
            return
        }

        if (assetTypeInstance.hasErrors()) {
            if (params._partial) {
                render(model: [assetTypeInstance: assetTypeInstance], view: "_partialEdit")
                return
            }
            respond assetTypeInstance.errors, view: 'edit'
            return
        }
        String msg = message(code: 'default.updated.message', args: [message(code: 'AssetType.label', default: 'AssetType'), assetTypeInstance.id])
        try {
            assetTypeInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [assetTypeInstance: assetTypeInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!assetTypeInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [assetTypeInstance: assetTypeInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect assetTypeInstance
            }
            '*' { respond assetTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AssetType assetTypeInstance) {

        if (assetTypeInstance == null) {
            notFound()
            return
        }

        String msg = message(code: 'default.deleted.message', args: [message(code: 'AssetType.label', default: 'AssetType'), assetTypeInstance.id])
        try {
            assetTypeInstance.delete flush: true
            if (params._partial) {
                render(model: [assetTypeInstance: assetTypeInstance], view: "_partialCreate")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                render(model: [assetTypeInstance: assetTypeInstance], view: "_message")
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
        String msg = message(code: 'default.not.found.message', args: [message(code: 'assetType.label', default: 'AssetType'), params.id])
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
