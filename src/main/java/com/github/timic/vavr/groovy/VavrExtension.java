package com.github.timic.vavr.groovy;

import groovy.lang.Closure;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FirstParam;
import io.vavr.Tuple;
import io.vavr.Value;
import io.vavr.collection.Traversable;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class VavrExtension {

    public static <T, V extends T> T getOrElse(Option<T> option, Closure<V> closure) {
        return option.getOrElse(closure::call);
    }

    public static <T, V extends T> Option<T> orElse(Option<T> option, Closure<Option<V>> closure) {
        return option.orElse(closure::call);
    }

    public static <T, L> Either<L, T> toEither(Value<T> value, Closure<? extends L> closure) {
        return value.toEither(closure::call);
    }

    public static <T, R> Either<T, R> toLeft(Value<T> value, Closure<? extends R> closure) {
        return value.toLeft(closure::call);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Traversable<V>, V> T takeWhile(
            T traversable, @ClosureParams(FirstParam.SecondGenericType.class) Closure<Boolean> closure) {
        return (T) traversable.takeWhile(closure::call);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Traversable<V>, V> T takeUntil(
            T traversable, @ClosureParams(FirstParam.SecondGenericType.class) Closure<Boolean> closure) {
        return (T) traversable.takeUntil(closure::call);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Traversable<V>, V> T dropWhile(
            T traversable, @ClosureParams(FirstParam.SecondGenericType.class) Closure<Boolean> closure) {
        return (T) traversable.dropWhile(closure::call);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Traversable<V>, V> T dropUntil(
            T traversable, @ClosureParams(FirstParam.SecondGenericType.class) Closure<Boolean> closure) {
        return (T) traversable.dropUntil(closure::call);
    }

    @SuppressWarnings("unchecked")
    public static <R, T extends Tuple> R getAt(T tuple, Integer index) {
        return (R) tuple.toSeq().get(index);
    }

}
