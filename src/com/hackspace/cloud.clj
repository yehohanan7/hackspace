(ns com.hackspace.cloud)

(use 'com.hackspace.constants)

(require '(com.hackspace [dropbox :as dropbox]))
(use '[clojure.data.json :only (read-json json-str)])

(defn get-dropbox-access []
  (println "enter dropbox id")
  (dropbox/get-access (read-line))
  )

(def providers [{:name :dropbox :get-access get-dropbox-access :user-file "hs.db.user"}])

(defn get-stats [user]
  (read-json (dropbox/get-stats user))
  )

(defn list-files [user]
  (read-json (dropbox/list-files user))
  )