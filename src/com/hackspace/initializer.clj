(ns com.hackspace.initializer)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(require '(com.hackspace [user :as user]))

(use 'com.hackspace.constants)

(defn initialize-user [hs-context]
  (let [current-user (user/current-user)]
    (dosync (alter hs-context assoc :hs-user current-user))
    hs-context
    )
  )

(defn initialize [hs-context]
  (println "initializing hackspace...")
  (initialize-user hs-context)
  (println "updated user " (deref hs-context))
  )
