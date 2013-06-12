(ns ohms-law-calculator.core-test
  (:use clojure.test
        ohms-law-calculator.core))

(deftest test-current
  (testing "Current should be 0 when voltage is 0"
    (is (= 0 (:amperage (calculate {:voltage 0 :resistance 4})))))
  (testing "Current should be 4 when voltage is 8 and resistance is 2"
    (is (= 4 (:amperage (calculate {:voltage 8 :resistance 2}))))))

(deftest test-voltage
  (testing "Voltage should be 8 when current is 4 and resistance is 2"
    (is (= 8 (:voltage (calculate {:amperage 4 :resistance 2}))))))

(deftest test-resistance
  (testing "Resistance should be 2 when current is 4 and voltage is 8"
    (is (= 2 (:resistance (calculate {:amperage 4 :voltage 8}))))))

(deftest test-gibberish
  (testing "failure to provide values should yield message"
    (is (= -1 (:undefined (calculate {:ham 2 :cheese 1 :bread 2})))))
  (testing "0 denominators should yield message"
    (is (= -1 (:undefined (calculate {:resistance 0 :voltage 12}))))
    (is (= -1 (:undefined (calculate {:voltage 4 :amperage 0})))))
  (testing "non numbers should yield message"
    (is (= -1 (:undefined (calculate {:amperage "whiskey" :voltage "soda"}))))))
