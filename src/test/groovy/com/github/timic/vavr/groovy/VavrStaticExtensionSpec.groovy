package com.github.timic.vavr.groovy

import io.vavr.collection.Stream
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

}
