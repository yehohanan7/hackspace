(ns sandbox.4clojure.iteratereimp)

(fn iter [f initial] (cons initial (lazy-seq (iter f (f initial)))))
