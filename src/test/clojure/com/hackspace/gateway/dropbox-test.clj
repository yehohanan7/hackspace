(ns com.hackspace.gateway.dropbox-test
  (:use clojure.test)
  )

(require '(com.hackspace.gateway.dropbox [dropbox :as dropbox]))

(def access-token "")
(def access-secret "")

(deftest should-fetch-accountdetails[]
  (let
    [_ (dropbox/init access-token access-secret)
     account-details (dropbox/account-details)]
    (is (= "John Pradeep" (:display-name account-details)))
    )

  )

