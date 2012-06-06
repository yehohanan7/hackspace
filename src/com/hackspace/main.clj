(ns com.hackspace.main
  (:gen-class ))

(require '(com.hackspace.gateway.dropbox [dropbox :as dropbox]))
(require '(com.hackspace.utils [fs :as fs]))
(use 'clojure.tools.cli)


(defn initialize []
  (println "trying to initialize hackspace...")
  (fs/initialize-config-files)
  )


(defn -main [& command_args]
  (let [[options args banner] (cli command_args
    ["-h" "-help" "Displays help." :default false, :flag true]
    ["-p" "-provider" "the file hosting provider" :default 'dropbox]
    ["-i" "-init" "initializes hackspace" :default false, :flag true]
    )]
    (if (:help options)
      (println banner)
      (do
        (cond (true? (:init options)) (initialize))
        )
      )
    (println options)
    )
  )




