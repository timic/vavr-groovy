### v0.4.0
* Make groovy compile only dependency 
* Update vavr to 0.10.2
* An extension methods split to separate classes
* Added few extensions to Map, Option, Either

Breaking change:
* Move pattern matching extensions to utility static methods
* `none()` renamed to `None()` 

### v0.2.3
* filter support

### v0.2.2
* Fixed Either#mapLeft signature hint

### v0.2.1
* map/flatMap support

### v0.2.0
* Fixed collection extension methods
* added group by support

### v0.1.1
vavr updated to 0.9.2

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
