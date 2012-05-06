(ns com.hackspace.gateway.dropbox-oauth-test
  (:use clojure.test)
  (:use com.hackspace.gateway.dropbox-oauth)
  )

(deftest should-construct-authorization-url
  (is (false (nil? (fetch-authorization-url))))
  )


