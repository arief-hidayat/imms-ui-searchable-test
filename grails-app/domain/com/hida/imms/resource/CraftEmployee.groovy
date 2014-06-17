package com.hida.imms.resource

import org.apache.commons.lang.builder.HashCodeBuilder

class CraftEmployee implements Serializable {
    long craftId
    long employeeId

    boolean equals(other) {
        if (!(other instanceof CraftEmployee)) {
            return false
        }

        other.craftId== craftId&&
                other.employeeId == employeeId
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        builder.append(craftId)
        builder.append(employeeId)
        builder.toHashCode()
    }

    static CraftEmployee get(long craftId, long employeeId) {
        find 'from CraftEmployee where craftId=:craftId and employeeId=:employeeId',
                [craftId: craftId, employeeId: employeeId]
    }
    static Set<Long> findAllEmployeeIdByCraftId(long craftId) {
        def res = findAll('from CraftEmployee where craftId=:craftId', [craftId: craftId])
        res.collect { it.employeeId } as Set
    }
    static Set<Long> findAllCraftIdByEmployeeId(long employeeId) {
        def res = findAll( 'from CraftEmployee where employeeId=:employeeId', [employeeId: employeeId])
        res.collect {it.craftId} as Set
    }

    static CraftEmployee create(long craftId, long employeeId, boolean flush = false) {
        new CraftEmployee(craftId: craftId, employeeId: employeeId).save(flush: flush, insert: true, failOnError : true)
    }

    static boolean remove(long craftId, long employeeId, boolean flush = false) {
        CraftEmployee instance = CraftEmployee.findByCraftIdAndEmployeeId(craftId, employeeId)
        instance ? instance.delete(flush: flush) : false
    }

    static void removeAll(Craft craft) {
        executeUpdate 'DELETE FROM CraftEmployee WHERE craftId=:craftId', [craftId: craft.id]
    }

    static void removeAll(Employee employee) {
        executeUpdate 'DELETE FROM CraftEmployee WHERE employeeId=:employeeId', [employeeId: employee.id]
    }

    static mapping = {
        id composite: ['craftId', 'employeeId']
        version false
//      craftId index : 'craftEmployeeIdx'
        employeeId index : 'craftEmployeeIdx'
    }
    static constraints = {
    }
}
