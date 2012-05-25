(use '[clojure.xml :only (parse)])
;;(println (parse (java.io.File. "testxml.xml")))

(println (for [x (xml-seq (parse (java.io.File. "testxml.xml"))) :when (= :employee (:tag x))] (:name x)))