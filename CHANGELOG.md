### v0.1.0
Dependencies:
* vavr dependency - 0.9.1
* groovy dependency - 2.4.13

Supported instance methods:
* `Option#getOrElse(Closure<T>)`
* `Option#orElse(Closure<Option<T>>)`
* `Value#toEither(Closure<LEFT>)`
* `Value#toLeft(Closure<RIGHT>)`
* `Traversable#takeWhile(Closure<Boolean>)`
* `Traversable#takeUntil(Closure<Boolean>)`
* `Traversable#dropWhile(Closure<Boolean>)`
* `Traversable#dropUntil(Closure<Boolean>)`
* vavr tuple multiple assignment

Supported static methods:
* `Option#when(Boolean, Closure<T>)`
* `Stream#iterate(T, Closure<T>)`
* `Stream#continually(Closure<T>)`
* `Try#of(Closure<T>)`
* pattern matching factories `Match` and `Case` included to `Object` static method
* `Option#none()` included to `Object` static method
