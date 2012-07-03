(ns com.hackspace.user)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(require '(com.hackspace [cloud :as cloud]))
(require 'clojure.string)
(use 'com.hackspace.constants)

(defrecord AccessData [provider id access-token access-secret])

(defn initialize-with [provider]
  (let [{:keys [id access-token access-secret]} ((:get-access provider))]
    (-> (:user-file provider) (fileutils/create) (fileutils/write-lines id access-token access-secret))
    (AccessData. (:name provider) id access-token access-secret)
    )
  )

(defn retrieve-data [provider]
  (let [[user-id access-token access-secret & others] (fileutils/read-lines (:user-file provider))]
    (AccessData. (:name provider) user-id access-token access-secret)
    )
  )

(defn new-or-existing? []
  (if (some #(fileutils/exists? %) (vals user-files)) :existing :new )
  )

(defmulti initialize-user new-or-existing?)

(defmethod initialize-user :new []
  (first (map initialize-with cloud/providers))
  )


(defmethod initialize-user :existing []
  (first (map retrieve-data cloud/providers))
  )


(defn current-user []
  (initialize-user)
  )


(defn get-stats []
  (let [user (current-user)]
    (cloud/get-stats user)
    )
  )

(defn list-files [directory]
  (let [user (current-user)]
    (cloud/list-files user directory)
    )
  )