[![Download](https://api.bintray.com/packages/timic/generic/vavr-groovy/images/download.svg)](https://bintray.com/timic/generic/vavr-groovy/_latestVersion)
[![Build Status](https://travis-ci.org/timic/vavr-groovy.svg?branch=master)](https://travis-ci.org/timic/vavr-groovy)
[![codecov](https://codecov.io/gh/timic/vavr-groovy/branch/master/graph/badge.svg)](https://codecov.io/gh/timic/vavr-groovy)

This library provides groovy extension modules which allows to use [vavr](http://vavr.io) functional data structures 
with groovy closures without a pain.

For example,

```groovy
def option = Option.when(true) {
  "True"
}

// when no extension provided closure argument will not coerce to supplier 
// because of Option has method signature Option#when(T object)
assert option.get() instanceof Closure

// as a workaround you can cast closure to supplier directly
Option.when(true, { "True" } as Supplier)

// or when extension provided this example just works as how it should
assert option.get() == "True"
```

### More examples

```groovy
// tuple multiple assignment
def (a, b, c) = new Tuple3(1, "A", true)

// infinite streams
assert Stream.iterate(1) {
  ++ it
}.take(3) == Stream.of(1, 2, 3)

// pattern matching
import static com.github.timic.vavr.groovy.API.*

assert Match(3).of(
    Case(1) {
        "One"
    },
    Case(3) {
        "Three"
    }) == "Three"
```

You can find more example in tests files.

### Download

Download via gradle:

```groovy
repositories {
    jcenter()
}

dependencies {
    compile "com.github.timic:vavr-groovy:0.3.0"
}
```
