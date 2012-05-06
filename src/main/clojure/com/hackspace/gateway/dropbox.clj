(ns com.hackspace.gateway.dropbox
  (:require [oauth.client :as oauth]))

(def consumer-key "ny5yv5yow0yfqwr")
(def consumer-secret "q5oemkk7d2muvxp")
(def urls {:request-token "https://api.dropbox.com/1/oauth/request_token"
           :access-token "https://api.dropbox.com/1/oauth/access_token"
           :authorize "https://www.dropbox.com/1/oauth/authorize"})

(def consumer (oauth/make-consumer
                consumer-key consumer-secret (:request-token urls) (:access-token urls) (:authorize urls)
                :hmac-sha1)
  )

(def request-token (oauth/request-token consumer))

(println "request token: " request-token)

(oauth/user-approval-uri consumer (:oauth_token request-token))

(def access-token-response (oauth/access-token consumer request-token))

(println access-token-response)