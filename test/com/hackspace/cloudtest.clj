(ns com.hackspace.cloudtest
  (:use midje.sweet)
  )

(require '(com.hackspace [cloud :as cloud]))


(fact "should attempt to get access to all cloud providers configured"
  (cloud/get-access :googledrive :dropbox) => {:gd-access-token "gd-access-token" :gd-access-secret "gd-access-secret" :db-access-token "db-access-token" :db-access-secret "db-access-secret"}
  (provided
    (cloud/get-cloud-access :dropbox) => {:db-access-token "db-access-token" :db-access-secret "db-access-secret"}
    (cloud/get-cloud-access :googledrive) => {:gd-access-token "gd-access-token" :gd-access-secret "gd-access-secret"}
    )
  )


(fact "should get access tokens to dropbox provider"
  (cloud/get-cloud-access :dropbox) => #(comp not nil?)
  )