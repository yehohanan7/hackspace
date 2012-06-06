(ns com.hackspace.test.oauthtest
  (:use clojure.test)
  )

(require '(com.hackspace.gateway.dropbox [oauth :as oauth]))


(deftest summa
  (is (= (+ 1 1) 2))
  )

;;(deftest should-identify-user
 ;; (let [existing-user {:username "john" :access-key "abcde" :access-secret "aalksjd"}
  ;;      new-user {:username "john"}
   ;;     ]
    ;;(is (= (oauth/usertype existing-user) :authorized-user))
    ;;(is (= (oauth/usertype new-user) :new-user))

    ;;)
  ;;)