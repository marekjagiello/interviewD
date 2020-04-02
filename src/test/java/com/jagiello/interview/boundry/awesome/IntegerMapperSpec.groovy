package com.jagiello.interview.boundry.awesome

import spock.lang.Specification
import spock.lang.Unroll

class IntegerMapperSpec extends Specification {

    @Unroll
    def "map '#inputString' to #expected"() {
        expect:
            expected == IntegerMapper.map(inputString)
        where:
            inputString     || expected
            ""              ||  []
            null            ||  []
            "1"             ||  [1]
            "1\n"           ||  [1]
            "1\n2\n3\n"     ||  [1, 2, 3]
    }
}
