(ns com.hackspace.dropbox)

(def consumerkey "ny5yv5yow0yfqwr")
(def consumersecret "q5oemkk7d2muvxp")


(defn get-access [user-name]
  {:id user-name :access-token "dummy access key" :access-secret "dummy access secret"}
  )

