(ns sandbox.4clojure.find-max)

(println (#(reduce (fn [x y] (if (> x y) x y)) %1 %&) 1 2 3 4 9 7 8))

#(last (sort %&))
