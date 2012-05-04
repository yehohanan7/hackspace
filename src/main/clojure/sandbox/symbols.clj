(ns sandbox.symbols)

(def a-symbol 'where-am-i)

(println (class a-symbol))
(println a-symbol)
(println (resolve 'a-symbol))

(println (resolve 'where-am-i))

(def test 'value)

(println (identical? 'test 'test))
