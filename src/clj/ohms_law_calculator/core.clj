(ns ohms-law-calculator.core)

(defn calculate [{:keys [voltage amperage resistance]}]
  (cond
   (and (number? voltage) (number? resistance) (> resistance 0))
   {:amperage (/ voltage resistance)}
   (and (number? amperage) (number? resistance)) {:voltage (* amperage resistance)}
   (and (number? voltage) (number? amperage) (> amperage 0)) {:resistance (/ voltage amperage)}
   :default {:undefined -1}))
