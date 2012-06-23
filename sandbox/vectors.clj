(ns sandbox.vectors)

(println (vec (range 10)))

(def names ["a" "b"])

(println (into names ["c" "d"]))

(println "nth element access....")

(println (nth names 1))

(println (names 1))

(println (get names 1))

(println "efficient modification using structural sharing..")

(println (assoc names 2 "changed"))

(println (replace {1 "changed again"} names))