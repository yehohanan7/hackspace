(ns com.hackspace.cloud)

(use 'com.hackspace.constants)

(require '(com.hackspace [dropbox :as dropbox]))
;;(require '[clj-http.client :as client])
;;(require ['oauth.client :as 'oauth])

(defn get-dropbox-access []
  (println "enter dropbox id")
  (dropbox/get-access (read-line))
  )

(def providers [{:name :dropbox :get-access get-dropbox-access :user-file "hs.db.user"}])

;;(def credentials (oauth/credentials "ny5yv5yow0yfqwr"))


;;(println (client/post "http://rest-test.heroku.com/" :query credentials))