(ns com.hackspace.utils.fs)

(use 'com.hackspace.constants)
(use 'clojure.java.io)
(import '(java.io File))


(defn create-if-not-exists [filename]
  (.createNewFile (File. filename))
  )

(defn initialize-config-files []
  (create-if-not-exists (config :user-file))
  )
