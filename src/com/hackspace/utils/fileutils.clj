(ns com.hackspace.utils.fileutils)

(require '(com.hackspace.utils [fileutils :as fileutils]))


(use 'clojure.java.io)
(import '(java.io File))

(defn exists? [filename]
  (.exists (File. filename))
  )

(defn create [filename]
  (.createNewFile (File. filename))
  filename
  )

(defn write-content [content file]
  (spit file content)
  )

(defn create-if-not-exists [filename]
  (.createNewFile (File. filename))
  )

(defn read-content [filename]
  (slurp filename)
  )

(defn read-lines [filename]
  (with-open [fr (reader filename)]
    (doall (line-seq fr)))
  )

(defn write-lines [filename & content]
  (spit filename (apply str (interpose "\n" content)))
  )