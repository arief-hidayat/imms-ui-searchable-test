package com.hida.imms


import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AssetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def createForm() {
        println "inside create form"
        render(model: [assetInstance: new Asset(params)], view: "_partialCreate")
    }

    def editForm(Asset assetInstance) {
        render(model: [assetInstance: assetInstance], view: "_partialEdit")
    }

    def showForm(Asset assetInstance) {
        render(model: [assetInstance: assetInstance], view: "_partialShow") //
    }

    def deleteJSON() {
        Asset assetInstance = Asset.get(params.id)
        if (assetInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            assetInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id]), params, OK)
            println "deleted successfully"
        } catch (Exception e) {
            log.error("Failed to delete Asset. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id]), params, INTERNAL_SERVER_ERROR)
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
        respond new Asset()
    }

    def show(Asset assetInstance) {
        if (params._partial) {
            render(model: [assetInstance: assetInstance], view: "_partialShow")
            return
        }
        respond assetInstance
    }

    def create() {
        if (params._partial) {
            render(model: [assetInstance: new Asset(params)], view: "_partialCreate")
            return
        }
        respond new Asset(params)
    }

    @Transactional
    def save(Asset assetInstance) {
        if (assetInstance == null) {
            notFound()
            return
        }

        if (assetInstance.hasErrors()) {
            if (params._partial) {
                render(model: [assetInstance: assetInstance], view: "_partialCreate")
                return
            }
            respond assetInstance.errors, view: 'create'
            return
        }



        String msg = message(code: 'default.created.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id])
        try {
            assetInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [assetInstance: assetInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!assetInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [assetInstance: assetInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect assetInstance
            }
            '*' { respond assetInstance, [status: CREATED] }
        }
    }

    def edit(Asset assetInstance) {
        if (params._partial) {
            render(model: [assetInstance: assetInstance], view: "_partialEdit")
            return
        }
        respond assetInstance
    }

    @Transactional
    def update(Asset assetInstance) {
        if (assetInstance == null) {
            notFound()
            return
        }

        if (assetInstance.hasErrors()) {
            if (params._partial) {
                render(model: [assetInstance: assetInstance], view: "_partialEdit")
                return
            }
            respond assetInstance.errors, view: 'edit'
            return
        }
        String msg = message(code: 'default.updated.message', args: [message(code: 'Asset.label', default: 'Asset'), assetInstance.id])
        try {
            assetInstance.save flush: true, failOnError: true
            if (params._partial) {
                render(model: [assetInstance: assetInstance], view: "_partialShow")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                response.status = 500
                if (!assetInstance.hasErrors()) {
                    flash.message = e.getMessage()
                }
                render(model: [assetInstance: assetInstance], view: "_message")
                return
            }
        }

        request.withFormat {
            form multipartForm {
                flash.message = msg
                redirect assetInstance
            }
            '*' { respond assetInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Asset assetInstance) {

        if (assetInstance == null) {
            notFound()
            return
        }

        String msg = message(code: 'default.deleted.message', args: [message(code: 'Asset.label', default: 'Asset'), assetInstance.id])
        try {
            assetInstance.delete flush: true
            if (params._partial) {
                render(model: [assetInstance: assetInstance], view: "_partialCreate")
                return
            }
        } catch (Exception e) {
            if (params._partial) {
                render(model: [assetInstance: assetInstance], view: "_message")
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
        String msg = message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])
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
