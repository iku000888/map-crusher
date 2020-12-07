(ns iku000888.map.crusher-test
  (:require [clojure.test :refer :all]
            [iku000888.map.crusher :refer :all]))

(deftest crush-test
  (testing "ok: simple value"
    (is (= {:a 1} (crush {:a 1}))))
  (testing "ok: simple nil value"
    (is (= {:a nil} (crush {:a nil}))))
  (testing "ok: simple map"
    (is (= {:a.b 2} (crush {:a {:b 2}}))))
  (testing "ok: simple list"
    (is (= {:a.b [3 4]} (crush {:a {:b [3 4]}}))))
  (testing "ok: nested map"
    (is (= {:a.b.c 5} (crush {:a {:b {:c 5}}}))))
  (testing "ok: nested map 2"
    (is (= {:foo.bar ["baz"]
            :works.with [:values :in :seq :if :primitive]}
           (crush {:foo {:bar ["baz"]}
                   :works {:with [:values :in :seq :if :primitive]}}))))
  )
