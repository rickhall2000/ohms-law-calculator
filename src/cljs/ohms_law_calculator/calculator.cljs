(ns ohms-law-calculator.calculator
  (:require [ohms-law-calculator.core :as calc]
            [domina :as dom]
            [domina.events :as ev]
            [cljs.reader :refer [read-string]]))

(defn call-calc []
  (let [amperage (read-string (dom/value (dom/by-id "current")))
        voltage (read-string  (dom/value (dom/by-id "voltage")))
        resistance (read-string  (dom/value (dom/by-id "resistance")))]
    (dom/set-inner-html! (dom/by-id "result")
                    (str (calc/calculate {:voltage voltage
                                          :resistance resistance
                                          :amperage amperage})))))

(defn reset-form []
  (do
    (dom/set-value! (dom/by-id "current") "0")
    (dom/set-value! (dom/by-id "voltage") "0")
    (dom/set-value! (dom/by-id "resistance") "0")))


(defn init []
  (if (and js/document
           (.-getElementById js/document))
    (do
      (ev/listen! (dom/by-id "calculate") :click call-calc)
      (ev/listen! (dom/by-id "reset") :click reset-form)
      (reset-form))))

(set! (.-onload js/window) init)
