package com.github.timic.vavr.groovy

import groovy.transform.CompileStatic
import io.vavr.collection.Stream
import io.vavr.control.Option
import spock.lang.Specification

class VavrStaticExtensionSpec extends Specification {

    void "stream iterate"() {
        expect:
            Stream.iterate(1) { ++it }.take(3) == Stream.of(1, 2, 3)
            Stream.iterate("Hello") { it.concat("!") }.take(4).last() == "Hello!!!"
    }

    void "stream continually"() {
        expect:
            Stream.continually { 1 }.take(3) == Stream.of(1, 1, 1)
    }

    void "option when"() {
        when:
            def opt = Option.when(true) {
                1
            }
        then:
            opt.defined
            opt.get() == 1
    }

    void "none factory method"() {
        when:
            Option<Integer> opt = testStaticNone()
        then:
            opt.empty

    }

    void "match case"() {
        expect:
            Match(5).of(
                    Case(5, "Equals"),
                    Case(3, "Not eqauls")) == "Equals"
            Match(5).of(
                    Case({ it > 4 }) { "Greater" },
                    Case({ it == 3 }, "Equals")) == "Greater"
            Match(5).of(
                    Case({ it == 5 }) { it ** 2 }) == 25
            Match(5).of(
                    Case(3, "False"),
                    // default case
                    Case {
                        "Default"
                    }) == "Default"
    }

    @CompileStatic
    private static Option<Integer> testStaticNone() {
        none()
    }

}
