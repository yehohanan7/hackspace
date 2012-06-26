(ns com.hackspace.cloud)
(use 'com.hackspace.constants)

(require '(com.hackspace [dropbox :as dropbox]))


(defmulti get-cloud-access (fn [input] input))

(defmethod get-cloud-access :googledrive [input]

  )

(defmethod get-cloud-access :dropbox [input]
  (println "pls enter your drop box id")
  (let [user-name (read-line)]
    (dropbox/get-access user-name)
    )
  )


(defn get-access [& providers]
  (apply merge (map get-cloud-access providers))
  )
