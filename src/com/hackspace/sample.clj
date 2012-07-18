(ns com.hackspace.sample)

(defn testadd [a b]
  (+ a b)
  )



(println (+ (testadd 2 3) 5))
(println (map #(* %1 2) [1 2]))

(println "vector experimentations...")

(def elements [1 2 3 4 5])

(subvec elements 1 3)

(vector? (first {:height 12 :weight 15}))

(doseq [[key val] {:key1 "val1" :key2 "val2"}]
  (println "key: " key "val: " val)
  )



