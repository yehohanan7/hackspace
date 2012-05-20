(ns sandbox.simplethread)

(def x 55)

(.start (Thread. #(println "Variable:" x)))
