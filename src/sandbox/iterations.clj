(ns sandbox.iterations)

(defn print-me [name times]
  (loop [i (- times 1)]
    (println name)
    (if (> i 0)
      (recur (dec i))
      )
    )
  )

(print-me "John" 5)

(dotimes [n 5]
  (println "Johny" )
  )

(def all-users [{:name "John"} {:name "Pradeep"}])

(doseq [user all-users]
  (println "Username: " (:name user))
  )


(println "mapping:::" (map #(.toUpperCase (:name %1)) all-users))

(defn special-user? [user]
  (= (:name user) "John")
  )

(println "special users:::" (filter special-user? all-users ))

(println "reduced::" (reduce + (range 1 5)))

(println (for [a "abcd"
      b [1 2 3 4]]
  [a b]
  ))
