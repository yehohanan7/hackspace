(ns main.clojure.sandbox.users)

;;(require '[clojure.contrib.string :as string])

;;(require '[clojure.contrib.string :as string])
(use '[clojure.contrib.string :only [blank?]])
(import '(com.hackspace.services UserService))

(def usermap {"john" "john", "user2" "user 2"})
(def user-service (UserService. usermap))

(defn find-user [username]
  (let [name (.findUser user-service username)]
    (if (blank? name)
      (throw (Exception. "User Not Found"))
      (.toUpperCase name)
      )
    )
  )

(println "user is : "
  [(try
     (println (find-user "user3"))
     (catch Exception e (str "could not find user")))]
)

(println (find-user "john"))



