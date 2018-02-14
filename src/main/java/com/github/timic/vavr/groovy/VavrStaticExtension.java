package com.github.timic.vavr.groovy;

import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FirstParam;
import io.vavr.API;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.function.Function;

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

    public static <T> Option<T> none(Object obj) {
        return Option.none();
    }

    public static <T> API.Match<T> Match(Object obj, T target) {
        return API.Match(target);
    }

    public static <T, R> API.Match.Case<T, R> Case(Object obj, T pattern, R ret) {
        return API.Case(API.$(pattern), ret);
    }

    public static <T, R> API.Match.Case<T, R> Case(Object obj, T pattern, Closure<R> supplier) {
        R ret = supplier.getMaximumNumberOfParameters() == 0 ? supplier.call() : supplier.call(pattern);
        return API.Case(API.$(pattern), ret);
    }

    public static <T, R> API.Match.Case<T, R> Case(
            Object obj, @ClosureParams(FirstParam.FirstGenericType.class) Closure<Boolean> predicate,
            R ret) {
        return API.Case(API.<T>$(predicate::call), ret);
    }

    public static <T, R> API.Match.Case<T, R> Case(
            Object obj, @ClosureParams(FirstParam.FirstGenericType.class) Closure<Boolean> predicate,
            Closure<R> supplier) {
        return API.Case(API.<T>$(predicate::call), (Function<T, R>) supplier::call);
    }

    public static <T, R> API.Match.Case<T, R> Case(Object obj, R ret) {
        return API.Case(API.$(), ret);
    }

    public static <T, R> API.Match.Case<T, R> Case(Object obj, Closure<R> supplier) {
        return API.Case(API.$(), (Function<T, R>) supplier::call);
    }

}
