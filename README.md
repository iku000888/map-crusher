# map-crusher

Turns a nester Clojure map into a flat (deps=1) map with concatted attributes representing the original nesting.

## Usage

```clojure
(requre '[iku000888.map.crusher :refer [crush])
(crush {:foo {:bar ["baz"]}
        :works {:with [:values :in :seq :if :primitive]}})

=>
{:foo.bar ("baz"),
 :works.with (:values :in :seq :if :primitive)}
```

## Caveat

This 'works' on nested vector values with the assumption that the values in the vector is homogenous.
In particular the result at a glance may not conform to intuition if the algorithm encounters something like this. However, this is by design to only contain primitive or seq of primitive values in the resulting map. (Otherwise the result is a nested map.)

```clojure
  (crush {:weird [:looking
                  {:if {:mix [:match :primitives {:in :seq}]}}]})
=>
{:weird.if.mix.in (:seq),
 :weird.if.mix (:match :primitives),
 :weird (:looking)}
```