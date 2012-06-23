(ns com.hackspace.usertest
  (:use midje.sweet))

(require '(com.hackspace [user :as user]))



(fact (user/loop-back 1) => 1)

