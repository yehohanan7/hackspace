(ns sandbox.4clojure.map-defaults)


;;(= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0})

;;(= (__ "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})

;;(= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})


#(fn [default coll] (into {} (map #(hash-map %1 default) coll)))

#(into {} (map (fn [k] [k %]) %2))

#(into {} (map vector %2 (repeat %)))



