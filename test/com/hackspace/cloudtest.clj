(ns com.hackspace.usertest
  (:use midje.sweet))

(require '(com.hackspace [cloud :as cloud]))


(fact "should attempt to get access to all cloud providers configured"
  (cloud/get-access [:googledrive :dropbox ]) => {:gd-access-token "gd-access-token" :gd-access-secret "gd-access-secret" :db-access-token "db-access-token" :db-access-secret "db-access-secret"}
  (provided
    (cloud/get-dropbox-access) => {:db-access-token "db-access-token" :db-access-secret "db-access-secret"}
    (cloud/get-googledrive-access) => {:gd-access-token "gd-access-token" :gd-access-secret "gd-access-secret"}
    )
  )