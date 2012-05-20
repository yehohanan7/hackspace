(defn print-seq [s]
  (when (seq s)
    (print (first s))
    (recur (rest s))
    )
  )

(print-seq [1 2 3 4 5])