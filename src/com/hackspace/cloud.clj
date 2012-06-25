(ns com.hackspace.cloud)

(use 'com.hackspace.constants)

(defmulti get-cloud-access (fn [input] input))

(defmethod get-cloud-access :googledrive [input]

  )

(defmethod get-cloud-access :dropbox [input]

  )


(defn get-access [& providers]
  (apply merge (map get-cloud-access providers))
  )
