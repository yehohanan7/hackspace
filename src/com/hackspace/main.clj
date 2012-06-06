(ns com.hackspace.main
  (:gen-class ))

(require '(com.hackspace.gateway.dropbox [dropbox :as dropbox]))
(use 'tools.cli)
(use 'tools.java.shell)


(let [[options args banner] (cli args
  ["-h" "--help" "Displays help." :default false, :flag true]
  ["-p" "--provider" "the file hosting provider"]
  )
      ]
  (println options)

  )



(defn -main [& command_args]
  (let [[options args banner] (cli command_args
    ["-h" "--help" "Displays help." :default false, :flag true]
    ["-p" "--provider" "the file hosting provider"]
    )]

    (println options)

    )
  )




