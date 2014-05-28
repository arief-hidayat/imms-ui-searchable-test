package com.hida.imms



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AssetTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
