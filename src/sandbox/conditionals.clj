(ns sandbox.conditionals)

(defn valid-number? [n]
  (> n 0)
  )

(defn check [n]
  (if (valid-number? n) (println "valid number") (println "invalid number"))
  )

(defn check-number [n]
  (cond
    (> n 0) (println "valid number")
    (< n 0) (println "invalid number")
    )
  )



(check -1)
(check-number -1)

(when (valid-number? 5) (println "valid number..."))

(defn admin? [name]
  (= name "John")
  )

(defn valid-user? [name]
  (= name "John")
  )

(defn welcome-user [name]
  (if (and (valid-user? name) (admin? name))
    (println "warm welcome")
    (println "hey there!")
    )
  )

(welcome-user "John")

