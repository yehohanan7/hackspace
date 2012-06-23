(ns sandbox.4clojure.groupbyreimp)



(defn group-it
  [f coll]
  (reduce
    (fn [result x]
      (println result x)
      (assoc result (f x) (conj (get result (f x) []) x))
      ) {true [7]} coll)  )

(println (group-it #(> % 5) [1 2 3 4 5 6]))