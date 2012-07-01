(ns com.hackspace.formatter)

(defn mega-bytes [value]
  (/ value 1000000M)
  )

(def default-formatter #(str "Display name : " % "\n"))

(def quota-formatter #(str "quota : " (mega-bytes (:quota %)) "M" ", normal : " (mega-bytes (:normal %)) "M" "\n"))

(defmulti display #(second %&))

(defmethod display :stats [data type]
  (let [display-formats {:display_name default-formatter :quota_info quota-formatter}]
    (map (fn [input] ((display-formats (first input)) (second input))) (filter #(contains? display-formats (key %)) data))
    )
  )


(defmethod display :init [data type]
  data
  )

(defmethod display :ls [data type]
  data
  )


;;(println (display {:display_name "jj" :normal "nor" :quota_info {:quota 1234 :normal 1111}} :stats))
