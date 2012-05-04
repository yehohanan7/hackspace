(ns sandbox)

(defn best [f xs]
  (reduce #(if (f %1 %2) %1 %2) xs)
  )

(println (best > [1 2 3 4 5]))