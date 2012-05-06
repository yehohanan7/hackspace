(ns sandbox.symbols)
(def jp "lasjdf")

(println (quote jp))
(println 'jp)
(println (meta #'jp))

(println #'jp)


(def temp 'value)

(println "temp: " temp)

(println (class 'testing))
(println (class #'jp))