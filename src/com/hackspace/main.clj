(ns com.hackspace.main
  (:use [clojure.tools.cli :only (cli)])
  (:gen-class ))

(require '(com.hackspace.gateway.dropbox [dropbox :as dropbox]))
(require '(com.hackspace [initializer :as initer]))
(require '(com.hackspace [user :as user]))
(require '(com.hackspace [formatter :as formatter]))

(def hs-context (ref {:hs-user {:id "dummy"}}))

(defn -main [& command_args]
  (let [[options args banner] (cli command_args
    ["-h" "--help" "Displays help." :flag true :default false]
    ["-p" "--provider" "the file hosting provider" :default 'dropbox]
    ["-s" "stats" "stats of your cloud usage"]
    ["-ls" "ls" "lists all files in your cloud store"]
    ["-i" "init" "initializes hackspace" :default false, :flag true]
    )]
    (when (:help options)
      (println banner)
      (System/exit 0))

    (if (:init options)
      (do
        (cond (true? (:init options)) (initer/initialize hs-context))
        )
      )
    (if (:stats options)
      (println "fetching statistics of your account....")
      (println (formatter/display (user/get-stats) :stats ))
      )

    (if (:ls options)
      (println "your cloud store summary")
      (println (formatter/display (user/list-files) :ls ))
      )
    )
  )


