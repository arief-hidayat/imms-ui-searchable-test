package com.hida.imms.resource


class Craft {

    String craft
    String note

    static constraints = {
        craft(unique: true, blank: false, nullable: false, size: 1..50)
        note(nullable: true, size: 0..76)
    }

    String toString() {
        return craft //CommonUtils.trimToString(craft)
    }

//    def getAvgMinCost() {
//        // the return value must be converted to default unit cost.
//        BigDecimal totalRate = new BigDecimal(0)
//        Set<Long> empIdList = CraftEmployee.findAllEmployeeIdByCraftId(this.id)
//        if(empIdList.isEmpty()) return totalRate
//        for(Long empId : empIdList) {
//            Employee emp = Employee.get(empId)
//            def rateSet = (emp.currentRates().collect {it?.rate ?: new BigDecimal(0)} ?: []) as Set
//            if (rateSet.size() > 0)
//                totalRate = totalRate.add(rateSet.min())
//        }
//        return new BigDecimal(totalRate.doubleValue() / empIdList.size())
//    }
}
