(ns com.hackspace.cloud)

(use 'com.hackspace.constants)

(require '(com.hackspace [dropbox :as dropbox]))

(defn get-dropbox-access []
  (println "enter dropbox id")
  (dropbox/get-access (read-line))
  )

(def providers [{:name :dropbox :get-access get-dropbox-access :user-file "hs.db.user"}])