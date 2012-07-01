(ns com.hackspace.dropbox
  (:gen-class ))

(import '(com.dropbox.client2.session AppKeyPair Session WebAuthSession RequestTokenPair Session$AccessType AccessTokenPair))
(import '(com.dropbox.client2 DropboxAPI))

(def consumerkey "ny5yv5yow0yfqwr")
(def consumersecret "q5oemkk7d2muvxp")


(defn user-authorized? []
  (loop [_ (println "Have you authorized the app to access your data?")
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
