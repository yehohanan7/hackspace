(ns sandbox.functions)

(println ((fn [e1 e2]
              #{e1 e2}
            ) 1 2))

(println ((fn [e1 e2 & extra]
              #{e1 e2 extra}
            ) 1 2))


(#(println %1) 5)

(def make-set
  (fn [e1 e2 & others]
    #{e1 e2 others}
    )
  )

(println (make-set 5 6 7))