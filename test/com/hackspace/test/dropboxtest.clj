(ns com.hackspace.test.dropboxtest
  (:use clojure.test)
  )

(require '(com.hackspace.gateway.dropbox [dropbox :as dropbox]))

(def access-token "7bd87vlxn96b865")
(def access-secret "w5pa7kzf0u30swx")

;;(deftest should-fetch-accountdetails []
;;  (let
 ;;   [_ (dropbox/init {:access-token access-token :access-secret access-secret})
  ;;   account-details (dropbox/account-details)]
   ;;  (println account-details)
    ;;(is (= "John Pradeep" (:display-name account-details)))
    ;;)

  ;;)


;;(defn tester []
;;  (let [_ (dropbox/init {:access-token access-token :access-secret access-secret })]
;;    (println (dropbox/account-details))
;;    )
;;  )

;;(tester)
