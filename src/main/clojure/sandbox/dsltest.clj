(defn method [projectname  map-args]
  (println "Project: " projectname)
  (println "Description: " (:description map-args))
  (println ":dependencies: " (:dependencies map-args))
  )

(method "hackspace" {:description "hack space" :dependencies ["module1" "version1"]})

