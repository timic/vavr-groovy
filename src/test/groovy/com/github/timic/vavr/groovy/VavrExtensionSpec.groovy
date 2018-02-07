package com.github.timic.vavr.groovy

import io.vavr.Tuple2
import io.vavr.Tuple3
import io.vavr.collection.List
import io.vavr.collection.Stream
import io.vavr.control.Either
import io.vavr.control.Option
import spock.lang.Specification

class VavrExtensionSpec extends Specification {

    void "option get or else"() {
        expect:
            Option.none().getOrElse { 1 } == 1
    }

    void "option when"() {
        expect:
            Option.when(true) { "OK" } == Option.some("OK")
    }

    void "option to left"() {
        expect:
            Option.none().toLeft { "RIGHT" } == Either.right("RIGHT")
    }

    void "option to either"() {
        expect:
            Option.none().toEither { "LEFT" } == Either.left("LEFT")
    }

    void "stream take while"() {
        when:
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5).takeWhile { it <= 3 }
        then:
            stream == Stream.of(1, 2, 3)
    }

    void "list take whike"() {
        when:
            List<Integer> list = List.of(1, 2, 3, 4, 5).takeWhile { it <= 3 }
        then:
            list == List.of(1, 2, 3)
    }

    void "stream take until"() {
        when:
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5).takeUntil { it > 3 }
        then:
            stream == Stream.of(1, 2, 3)
    }

    void "stream drop while"() {
        expect:
            Stream.of(1, 2, 3, 4, 5).dropWhile { it < 3 } == Stream.of(3, 4, 5)
    }

    void "stream drop until"() {
        expect:
            Stream.of(1, 2, 3, 4, 5).dropUntil { it > 2 } == Stream.of(3, 4, 5)
    }

    void "should extract tuple variables"() {
        when:
            def (int a, String b) = new Tuple2<Integer, String>(1, "Test")
        then:
            a == 1
            b == "Test"
        when:
            def (boolean c, long d, Map e) = new Tuple3<Boolean, Long, ?>(true, 10L, [a: 1])
        then:
            c
            d == 10L
            e == [a: 1]
    }

}
