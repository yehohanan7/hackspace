(ns com.hackspace.main
  (:use [clojure.tools.cli :only (cli)])
  (:gen-class ))

(require '(com.hackspace [initializer :as initer]))
(require '(com.hackspace [user :as user]))
(require '(com.hackspace [formatter :as formatter]))
(require '(com.hackspace [handler :as handler]))

(def hs-context (ref {:hs-user {:id "dummy"}}))

(defn -main [& command_args]
  (let [[options args banner] (cli command_args
    ["-help" "--help" "Displays help." :flag true :default false]
    ["-stats" "stats" "stats of your cloud usage" :default false, :flag true]
    ["-ls" "ls" "lists all files in your cloud store" :default false]
    ["-init" "init" "initializes hackspace" :default false, :flag true]
    ["-get" "meta" "downloads a file" :default false]
    )]
    (when (:help options)
      (println banner)
      (System/exit 0))

    (println options)
    (if (:init options)
      (do
        (cond (true? (:init options)) (initer/initialize hs-context))
        )
      )
    (when (:stats options)
      (println "fetching statistics of your account....")
      (println (formatter/display (user/get-stats) :stats ))
      )
    (when (not (false? (:ls options)))
      (println "your cloud store summary")
      (println (formatter/display (user/list-files (:ls options)) :ls ))
      )

    (when (not (false? (:get options)))
      (let [file-name (:get options)]
        (handler/handle :get (user/get-file file-name) file-name)
        )
      )
    )

  )


