(ns com.hackspace.main
  (:use [clojure.tools.cli :only (cli)])
  (:gen-class ))

(require '(com.hackspace.gateway.dropbox [dropbox :as dropbox]))
(require '(com.hackspace.utils [fs :as fs]))


(defn initialize []
  (println "trying to initialize hackspace...")
  (fs/initialize-config-files)
  )


(defn -main [& command_args]
  (let [[options args banner] (cli command_args
    ["-h" "--help" "Displays help." :flag true :default false]
    ["-p" "--provider" "the file hosting provider" :default 'dropbox]
    ["-i" "--init" "initializes hackspace" :default false, :flag true]
    )]
    (when (:help options)
      (println banner)
      (System/exit 0))

    (if (:init options)
      (do
        (cond (true? (:init options)) (initialize))
        )
      )
    )
  )


(initialize)


