(use '[clojure.contrib.duck-streams :only (reader)])
(println (take 2 (line-seq (reader "main.clj"))))