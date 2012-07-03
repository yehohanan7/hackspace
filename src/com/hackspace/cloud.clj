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

(defn- clean [input]
  (if (= '\/ (first input)) (apply str (rest input)) input)
  )

(defn- empty-if-nil [input]
  (if (nil? input) "" (clean input))
  )

(defn list-files [user directory]
  (let [directory-to-query (empty-if-nil directory)]
    (read-json (dropbox/list-files user directory-to-query)))
  )


(defn get-file [user file]
  (dropbox/get-file user (clean (empty-if-nil file)))
  )