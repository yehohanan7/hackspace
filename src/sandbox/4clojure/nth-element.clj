(ns sandbox.4clojure.nth-element)

(defn nth-element [coll n]
  (first (last (take n (iterate rest coll))))
)

#(first (drop %2 %1))

(println (nth-element '(2 3 4 5 8 9) 5))