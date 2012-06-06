(ns sandbox.4clojure.drop-every-nth)



;;(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])

;;(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])

;;(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])


(defn drop-every-nth [coll n]
    (keep-indexed #(if (or (< (inc %1) n) (not= (rem (inc %1) n) 0)) %2) coll)
  )



#(apply concat (partition-all (- %2 1) %2 %))


(println (drop-every-nth [1 2 3 4 5 6 7 8] 3))
