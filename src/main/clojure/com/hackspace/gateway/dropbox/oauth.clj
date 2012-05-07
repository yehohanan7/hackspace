(ns com.hackspace.gateway.dropbox.oauth)

(import '(com.dropbox.client2.session AppKeyPair Session WebAuthSession RequestTokenPair Session$AccessType AccessTokenPair))
(import '(com.dropbox.client2 DropboxAPI))

(def consumerkey "")
(def consumersecret "")


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

(defn re-bind-a-session [access-key access-secret]
  (let
    [session (open-session consumerkey consumersecret)
     access-token-pair (AccessTokenPair. access-key access-secret)
     ]
    (.setAccessTokenPair session access-token-pair)
    session
    )
  )

(defn oauth-a-session []
  (let
    [session (open-session consumerkey consumersecret)
     auth-info (.getAuthInfo session)
     ]
    (println "access this link and provide permission:  " (.url auth-info))
    (when (user-authorized?)
      (. session (retrieveWebAccessToken (.requestTokenPair auth-info)))
      session
      )
    )
  )

(defn get-session
  ([] (oauth-a-session))
  ([access-key access-secret] (re-bind-a-session access-key access-secret))
  )

(defn get-api
  ([] (DropboxAPI. (get-session)))
  ([access-key access-secret]
    (DropboxAPI. (get-session access-key access-secret))
    )
  )


;;(println (. session (getAccessTokenPair) (key)))
;;(println (. session (getAccessTokenPair) (secret)))