(ns com.hackspace.initializer)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(require '(com.hackspace [user :as user]))

(use 'com.hackspace.constants)

(defn initialize []
  (println "initializing hackspace...")
  (not (nil? (user/current-user)))
  )
