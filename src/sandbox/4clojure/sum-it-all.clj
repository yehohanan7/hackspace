(ns sandbox.4clojure.sum-it-all)

(defn sum-it [coll]
  (reduce + coll)
)

(println (sum-it [1 2 3 4 5]))

(println "test")

;; apply +


