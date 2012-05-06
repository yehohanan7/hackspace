(ns sandbox.threadfirst)

(defn amount [principle rate time-periods]
  (* (Math/pow (+ 1 (/ rate 100)) time-periods) principle)
  )

(println (amount 222 21 5))


(defn total-amount [principle rate time-periods]
  (-> rate
      (/ 100)
      (+ 1)
      (Math/pow time-periods)
      (* principle)
    )
  )

(println (total-amount 222 21 5))