(ns com.hackspace.maintest
  (:use clojure.test midje.sweet)
  (:use com.hackspace.initializer))


(fact (initialize {}) => 'true
  (provided (user/current-user) => {:name "test"}))

(fact (initialize {}) => 'true
  (provided (user/current-user) => nil))
