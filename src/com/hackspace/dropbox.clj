(ns com.hackspace.dropbox
  (:gen-class ))

(import '(com.dropbox.client2.session AppKeyPair Session WebAuthSession RequestTokenPair Session$AccessType AccessTokenPair))
(import '(com.dropbox.client2 DropboxAPI))
(require '(com.hackspace [oauth :as oauth]))

(def consumerkey "ny5yv5yow0yfqwr")
(def consumersecret "q5oemkk7d2muvxp")


(defn user-authorized? []
  (loop [_ (println "Have you authorized the app to access your data?(yes/no)")
         user-input (read-line)]
    (if (= user-input "yes")
      'true
      (recur nil read-line))
    )
  )

(defn open-session [consumer-key consumer-secret]
  (WebAuthSession. (AppKeyPair. consumer-key consumer-secret) (Session$AccessType/DROPBOX))
  )


(defn get-access-keys [user-name]
  (let
    [session (open-session consumerkey consumersecret)
     auth-info (.getAuthInfo session)
     ]
    (println "access this link and provide permission:  " (.url auth-info))
    (when (user-authorized?)
      (. session (retrieveWebAccessToken (.requestTokenPair auth-info)))
      (let [key-pairs (. session (getAccessTokenPair))]
        [(.key key-pairs) (.secret key-pairs)]
        )
      )
    )
  )

(defn get-access [user-name]
  (let [[access-token access-key] (get-access-keys user-name)]
    {:id user-name :access-token access-token :access-secret access-key}
    )
  )


(defn get-stats [user]
  (oauth/http-get "https://api.dropbox.com/1/account/info" (:access-token user) (:access-secret user) {})
  )

(defn list-files [user directory]
  (oauth/http-get (str "https://api.dropbox.com/1/metadata/dropbox/" directory) (:access-token user) (:access-secret user) {})
  )

(defn get-file [user file]
  (oauth/http-get (str "https://api-content.dropbox.com/1/files/dropbox/" file) (:access-token user) (:access-secret user) {})
  )

(def supported-operations {:get-access get-access :get-stats get-stats :list-files list-files :get-file get-file})

(def api {:name "dropbox" :user-file "hs.db.user" :operations supported-operations})
