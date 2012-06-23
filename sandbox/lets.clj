(ns sandbox.lets)

(defn area [radius]
  (let [pi 3.14
        r-square (* radius radius)
        ]
    (* pi r-square)
    )
  )

(println (area 5))
