(ns com.hackspace.main
  (:use [clojure.tools.cli :only (cli)])
  (:gen-class ))

(require '(com.hackspace [initializer :as initer]))
(require '(com.hackspace [user :as user]))
(require '(com.hackspace [formatter :as formatter]))

(def hs-context (ref {:hs-user {:id "dummy"}}))

(defn -main [& command_args]
  (let [[options args banner] (cli command_args
    ["-help" "--help" "Displays help." :flag true :default false]
    ["-stats" "stats" "stats of your cloud usage" :default false, :flag true]
    ["-ls" "ls" "lists all files in your cloud store" :default false, :flag true]
    ["-init" "init" "initializes hackspace" :default false, :flag true]
    )]
    (when (:help options)
      (println banner)
      (System/exit 0))

    (if (:init options)
      (do
        (cond (true? (:init options)) (initer/initialize hs-context))
        )
      )
    (when (:stats options)
      (println "fetching statistics of your account....")
      (println (formatter/display (user/get-stats) :stats ))
      )
    (when (:ls options)
      (println "your cloud store summary")
      (println (formatter/display (user/list-files) :ls ))
      )
    )
  )


