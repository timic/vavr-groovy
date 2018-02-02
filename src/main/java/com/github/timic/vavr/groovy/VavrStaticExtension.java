package com.github.timic.vavr.groovy;

import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FirstParam;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

public class VavrStaticExtension {

    public static <T> Stream<T> iterate(
            Stream stream, T obj, @ClosureParams(FirstParam.FirstGenericType.class) Closure<? extends T> closure) {
        return Stream.iterate(obj, closure::call);
    }

    public static <T> Stream<T> continually(Stream stream, Closure<? extends T> closure) {
        return Stream.continually(closure::call);
    }

    public static <T> Option<T> when(Option option, boolean test, Closure<T> closure) {
        return Option.when(test, closure::call);
    }

}
