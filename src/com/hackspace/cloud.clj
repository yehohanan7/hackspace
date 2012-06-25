(ns com.hackspace.cloud)
(use 'com.hackspace.constants)

(defmulti get-cloud-access #(%))

(defmethod get-access :googledrive []

  )

(defmethod get-access :dropbox []

  )


(defn get-access []
  (mapcat get-access cloud-providers)
  )