(ns com.hackspace.gateway.dropbox.oauth)

(import '(com.dropbox.client2.session AppKeyPair Session WebAuthSession RequestTokenPair Session$AccessType AccessTokenPair))
(import '(com.dropbox.client2 DropboxAPI))

(def consumerkey "ny5yv5yow0yfqwr")
(def consumersecret "q5oemkk7d2muvxp")

(defn open-session [consumer-key consumer-secret]
  (WebAuthSession. (AppKeyPair. consumer-key consumer-secret) (Session$AccessType/DROPBOX))
  )


;;*************************** session initializer *************************

(defn user-authorized? []
  (loop [_ (println "Have you authorized the app to access your data?")
         user-input (read-line)]
    (if (= user-input "yes")
      'true
      (recur nil read-line))
    )
  )


(defn usertype [user]
  (if (and (nil? (:access-key user)) (nil? (:access-secret user)))
    :new-user :authorized-user ))

(defmulti get-session usertype)

(defmethod get-session :authorized-user [user]
  (let
    [session (open-session consumerkey consumersecret)
     access-token-pair (AccessTokenPair. (:access-token user) (:access-secret user))
     ]
    (.setAccessTokenPair session access-token-pair)
    session
    )
  )

(defmethod get-session :new-user [user]
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

;;************* end of session initializer ***********************


(defn get-api [user]
  (DropboxAPI. (get-session user))
  )

