package com.hida.imms

import grails.converters.JSON
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AssetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond new Asset()
    }

    def show(Asset assetInstance) {
        respond assetInstance
    }

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

    def saveJSON() {
        if(params.id) {

        }
    }

    def deleteJSON() {
        Asset assetInstance = Asset.get(params.id)
        println "inside deleteJSON. assetInstance; ${assetInstance}"
        if(assetInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            assetInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id]), params, OK)
            println "deleted successfully"
        } catch(Exception e) {
            log.error("Failed to delete Asset. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id]), params, INTERNAL_SERVER_ERROR)
            println "item couldn't be deleted"
        }
    }

    private def renderJsonMessage(String msg, def params, HttpStatus status) {
        render(status: status, contentType: "application/json;  charset=utf-8") {
            [message : msg, params : params]
        }
    }

    def create() {
        respond new Asset(params)
    }

    @Transactional
    def save(Asset assetInstance) {
        if (assetInstance == null) {
            notFound()
            return
        }

        if (assetInstance.hasErrors()) {
            respond assetInstance.errors, view: 'create'
            return
        }

        assetInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'asset.label', default: 'Asset'), assetInstance.id])
                redirect assetInstance
            }
            '*' { respond assetInstance, [status: CREATED] }
        }
    }

    def edit(Asset assetInstance) {
        respond assetInstance
    }

    @Transactional
    def update(Asset assetInstance) {
        if (assetInstance == null) {
            notFound()
            return
        }

        if (assetInstance.hasErrors()) {
            respond assetInstance.errors, view: 'edit'
            return
        }

        assetInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Asset.label', default: 'Asset'), assetInstance.id])
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

        assetInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Asset.label', default: 'Asset'), assetInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'asset.label', default: 'Asset'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
