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


(def a-symbol 'where-am-i)

(println (class a-symbol))
(println a-symbol)
(println (resolve 'a-symbol))

(println (resolve 'where-am-i))

(def test 'value)

(println (identical? 'test 'test))

