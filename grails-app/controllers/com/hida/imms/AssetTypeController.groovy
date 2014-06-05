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
        if(assetTypeInstance == null) {
            renderJsonMessage(message(code: 'default.not.found.message', args: [message(code: 'assetType.label', default: 'AssetType'), params.id]), params, NOT_FOUND)
            println "item not found"
            return
        }
        try {
            assetTypeInstance.delete flush: true
            renderJsonMessage(message(code: 'default.deleted.message', args: [message(code: 'assetType.label', default: 'AssetType'), assetTypeInstance.id]), params, OK)
            println "deleted successfully"
        } catch(Exception e) {
            log.error("Failed to delete AssetType. params ${params}", e)
            renderJsonMessage(message(code: 'default.not.deleted.message', args: [message(code: 'assetType.label', default: 'AssetType'), assetTypeInstance.id]), params, INTERNAL_SERVER_ERROR)
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
        respond new AssetType()
    }

    def show(AssetType assetTypeInstance) {
        respond assetTypeInstance
    }

    def create() {
        respond new AssetType(params)
    }

    @Transactional
    def save(AssetType assetTypeInstance) {
        if (assetTypeInstance == null) {
            notFound()
            return
        }

        if (assetTypeInstance.hasErrors()) {
            respond assetTypeInstance.errors, view:'create'
            return
        }

        assetTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'assetType.label', default: 'AssetType'), assetTypeInstance.id])
                redirect assetTypeInstance
            }
            '*' { respond assetTypeInstance, [status: CREATED] }
        }
    }

    def edit(AssetType assetTypeInstance) {
        respond assetTypeInstance
    }

    @Transactional
    def update(AssetType assetTypeInstance) {
        if (assetTypeInstance == null) {
            notFound()
            return
        }

        if (assetTypeInstance.hasErrors()) {
            respond assetTypeInstance.errors, view:'edit'
            return
        }

        assetTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AssetType.label', default: 'AssetType'), assetTypeInstance.id])
                redirect assetTypeInstance
            }
            '*'{ respond assetTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AssetType assetTypeInstance) {

        if (assetTypeInstance == null) {
            notFound()
            return
        }

        assetTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AssetType.label', default: 'AssetType'), assetTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'assetType.label', default: 'AssetType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
