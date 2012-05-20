(ns com.hackspace.gateway.dropbox.dropbox)

(require '(com.hackspace.gateway.dropbox [oauth :as oauth]))

(defn mega-bytes [value]
  (/ value 1000000M)
  )


(def dropbox nil)

(defn account-info [api]
  (let [account (.accountInfo api)]
    {:display-name (.displayName account) :uid (.uid account) :referral-link (.referralLink account) :quota (mega-bytes (.quota account))}
    )
  )

(defn construct-operations [api]
  {:api api :account-info #(account-info api)}
  )

(defn account-details []
  {:pre [(false? (nil? dropbox))]}
  ((:account-info dropbox))
  )

(defn usertype [user]
  (if (and (nil? (:access-key user)) (nil? (:access-secret user)))
    :new-user :authorized-user ))


;;**************** drop box initializer *************************
(defn usertype [user]
  (if (and (nil? (:access-key user)) (nil? (:access-secret user)))
    :new-user :authorized-user ))

(defmulti welcome-user usertype)

(defmethod welcome-user :new-user [user]
  (println "Trying to connect to dropbox assuming you to be a new hackspace user...")
  )

(defmethod welcome-user :authorized-user [user]
  (println "welcome back to hackspace, connecting to dropbox...")
  )

(defn init [user]
  (welcome-user user)
  (def dropbox (construct-operations (oauth/get-api user)))
  )

