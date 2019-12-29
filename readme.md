[![Build Status](https://travis-ci.org/RutledgePaulV/reddington.svg?branch=develop)](https://travis-ci.org/RutledgePaulV/reddington)
[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.rutledgepaulv/reddington.svg)](https://clojars.org/org.clojars.rutledgepaulv/reddington)

### Reddington

> As a rule, I consider jealousy to be a base emotion, but in this case it's quite endearing. - Raymond Reddington

### What
A collection of reader tags for enhanced local development.


### Install

```clojure
[org.clojars.rutledgepaulv/reddington "0.1.0"]
```

### Examples

```clojure
; to pretty print the form that follows and the result of evaluation
#pp (form-to-observe)

; to profile the form that follows using clj-async-profiler and open the svg
#prof (form-to-observe)

; to benchmark the form that follows using criterium
#bench (form-to-observe)
```