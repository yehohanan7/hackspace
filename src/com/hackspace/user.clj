(ns com.hackspace.user)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(require 'clojure.string)
(use 'com.hackspace.constants)

(defn new-or-existing? []
  (if (fileutils/exists? user-file) :existing :new)
  )

(defmulti initialize-user new-or-existing?)

(defmethod initialize-user :new []
  (println "Enter your drop box user id: ")
  (fileutils/create user-file)
  (let [user-id (read-line)]
    (fileutils/write-lines user-file user-id)
    {:id user-id}
    )
  )

(defmethod initialize-user :existing []
  (let [[user-id access-token access-secret & others] (fileutils/read-lines)]
    {:id user-id :access-token access-token :access-secret access-secret}
    )
  )


(defn current-user []
  (initialize-user)
  )