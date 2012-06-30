(ns com.hackspace.usertest
  (:use midje.sweet))

(require '(com.hackspace [user :as user]))
(require '(com.hackspace.utils [fileutils :as fileutils]))
(require 'clojure.string)
(use 'com.hackspace.constants)


;(fact "should be able to identify the user as a new user or an existing user"
;  (user/new-or-existing?) => :new
;  (provided
;    (fileutils/exists? user-file) => false)
;  )



