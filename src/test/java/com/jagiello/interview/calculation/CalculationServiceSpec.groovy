package com.jagiello.interview.calculation

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class CalculationServiceSpec extends Specification {

    @Subject
    def service = new CalculationService()

    @Unroll
    def "calculate magic numbers #a and #b return #result"() {
        expect:
            service.addMagicNumbers(a, b) == result
        where:
            a       | b     || result
            2       | 2     || 4
            null    | 2     || 2
            null    | null  || 0
            Integer.MAX_VALUE    | Integer.MAX_VALUE  || 0
    }
}
