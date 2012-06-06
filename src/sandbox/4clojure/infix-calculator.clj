(ns com.hackspace.sandbox.4clojure)

(defn infix-calculator [& infixes]
  (if (= (count infixes) 1)
    (first infixes)
    (let [[x operator y & others] infixes]
      (recur (cons (operator x y) others))
    )
  )
)

(println (infix-calculator 2 + 3 + 4))