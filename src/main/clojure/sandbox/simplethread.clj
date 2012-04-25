(ns com.hackspace.simplethread)

(def x 55)

(.start (Thread. #(println "Variable:" x)))
