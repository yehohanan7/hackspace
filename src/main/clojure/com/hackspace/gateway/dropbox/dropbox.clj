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

(defn init
  ([] (def dropbox (construct-operations (oauth/get-api))))
  ([token secret] (def dropbox (construct-operations (oauth/get-api token secret))))
  )

(defn account-details []
  {:pre [(false? (nil? dropbox))]}
  ((:account-info dropbox))
  )

