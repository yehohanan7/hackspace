(ns com.hackspace.user)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(require 'clojure.string)
(use 'com.hackspace.constants)

(defn initialize-new-user []
  (println "Enter your drop box user id: ")
  (fileutils/create user-file)
  (let [user-id (read-line)]
    (fileutils/write-content user-id user-file)
    {:id user-id}
    )
  )

(defn current-user []
  (if (fileutils/exists? user-file)
    (load-string (fileutils/read-content user-file))
    (initialize-new-user)
    )
  )

(println (current-user))
