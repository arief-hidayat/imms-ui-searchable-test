package com.hida.imms.resource
//
//import com.portek.imms.common.ShouldBe

class Employee {
    String code
    String firstName
    String lastName
    String jobTitle
//  Department department
    String departmentCd
    String note
    String officePhone
    String homePhone
    String mobilePhone
    String officeEmail
    String otherEmail
    String faxNumber
    String addressLine1
    String addressLine2
    String city
    String state
    String zip
    String country
//  EmployeeType employeeType
    String employeeTypeCd


//    static def getEmployeeRate(Employee employee, RateType rateType) {
//        EmployeeRate.getRateAtDate(employee.id, rateType.rateType, ShouldBe.today)?.rate ?: new BigDecimal(0)
//    }
//    def currentRates() {
//        def res= []
//        RateType.list().each {
//            res << EmployeeRate.getRateAtDate(this.id, it.rateType, null)
//        }
//        return res
//    }

    static constraints = {
        code(unique: true, blank: false, nullable: false, size: 1..20)
        firstName(blank: false, nullable: false, size: 1..50)
        lastName(nullable: true, size: 0..50)
        jobTitle(nullable: false, size: 0..30)
        departmentCd(nullable: true)
        note(nullable: true, size: 0..76)
        officePhone(nullable: true, size: 0..24)
        homePhone(nullable: true, size: 0..16)
        mobilePhone(nullable: true, size: 0..16)
        officeEmail(nullable: true, email: true, size: 0..50)
        otherEmail(nullable: true, email: true, size: 0..50)
        faxNumber(nullable: true, size: 0..16)
        addressLine1(nullable: true, size: 0..50)
        addressLine2(nullable: true, size: 0..50)
        city(nullable: true, size: 0..50)
        state(nullable: true, size: 0..50)
        zip(nullable: true, size: 0..16)
        country(nullable: true, size: 0..50)
    }

//    def afterInsert = {
//        def empId = this.id
//        EmployeeRate.withNewSession {
//            RateType.list().each {
//                new EmployeeRate(employeeId: empId, rateType: it.rateType, rate: new BigDecimal(0), validFrom: ShouldBe.today).
//                        save(flush: true)
//            }
//        }
//    }

    String toString() {
        return "${firstName} ${(lastName ?: '')}"// CommonUtils.trimToString("${firstName} ${(lastName ?: '')}")
    }

    boolean equals(Object o) {
        return o instanceof Employee && code.equals(o.code);
    }
//TODO: consider to remove the following APIs:

//    static Employee findByEmployeeInactiveDates(EmployeeInactiveDate employeeInactiveDate) {
//        Employee.get(employeeInactiveDate.employeeId)
//    }
//
//    static Employee findByEmployeeRates(EmployeeRate employeeRate) {
//        return Employee.get(employeeRate.employeeId)
//    }
//
//    static long getEmployeeId(Employee employee) {
//        return employee.id
//    }

}
