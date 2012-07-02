(ns com.hackspace.formatter)

(defn mega-bytes [value]
  (/ value 1000000M)
  )

(def default-formatter #(str "Display name : " % "\n"))

(def quota-formatter #(str "quota : " (mega-bytes (:quota %)) "M" ", normal : " (mega-bytes (:normal %)) "M" "\n"))

(defmulti display #(second %&))



;;*******************************STATS FORMATTER********************************************************

(defmethod display :stats [data _]
  (let [display-formats {:display_name default-formatter :quota_info quota-formatter}]
    (map (fn [input] ((display-formats (first input)) (second input))) (filter #(contains? display-formats (key %)) data))
    )
  )

;;*******************************INIT FORMATTER********************************************************

(defmethod display :init [data _]
  data
  )


;;*******************************LS FORMATTER********************************************************


(defn- format-element [element max-path]
  (let [required-spaces (- max-path (count (:path element)))]
    (str (:path element) (apply str (take required-spaces (repeat required-spaces " "))) ":" (:size element) "\n")
    )
  )

(defn- longest-path [input]
  (count (:path (first (reverse (sort-by #(count (:path %)) (:contents input))))))
  )


(defmethod display :ls [data _]
  (let [max-path (longest-path data)]
    (loop [collection (:contents data) formatted-string ""]
      (if (empty? collection) formatted-string
        (recur (rest collection) (str formatted-string (format-element (first collection) max-path)))
        )
      )

    )
  )

;;(println (display {:display_name "jj" :normal "nor" :quota_info {:quota 1234 :normal 1111}} :stats))
