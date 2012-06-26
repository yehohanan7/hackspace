(ns com.hackspace.user)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(require '(com.hackspace [cloud :as cloud]))
(require 'clojure.string)
(use 'com.hackspace.constants)


(defn initialize-with [provider]
  (let [{:keys [id access-token access-secret]} (cloud/get-access provider) user-file (user-files provider)]
    (fileutils/create user-file)
    (fileutils/write-lines user-file id access-token access-secret)
    {provider {:id id :access-token access-token :access-secret access-secret}}
    )

  )

(defn retrieve-data [provider]
  (let [[user-id access-token access-secret & others] (fileutils/read-lines (user-files provider))]
    {provider {:id user-id :access-token access-token :access-secret access-secret}}
    )
  )

(defn new-or-existing? []
  (if (some #(fileutils/exists? %) (vals user-files)) :existing :new )
  )

(defmulti initialize-user new-or-existing?)

(defmethod initialize-user :new []
  (apply merge (map initialize-with cloud-providers))
  )


(defmethod initialize-user :existing []
  (apply merge (map retrieve-data cloud-providers))
  )


(defn current-user []
  (initialize-user)
  )