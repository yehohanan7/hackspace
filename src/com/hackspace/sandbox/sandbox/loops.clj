(ns com.hackspace.sandbox.loops)

(defn print-down-from [x]
  (when (pos? x)
    (println x)
    (recur (dec x))
    )
  )

(print-down-from 7)

(defn sum-down-from [sum x]
  (if (pos? x)
    (recur (+ sum x) (dec x))
    sum
    )
  )

(defn sum-it [num]
  (loop [sum 0
         x num
         ]
    (if (pos? x)
      (recur (+ sum x) (dec x))
      sum
      )
    )
  )

(println (sum-down-from 0 5))
(println (sum-it 5))