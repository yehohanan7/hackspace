(ns com.hackspace.utils.fstest
  (:use clojure.test)
  (:use com.hackspace.utils.fs))

(import '(java.io File))

(deftest should-create-new-file []
  (is (true? (create-if-not-exists "sample.txt")))
  (.delete (File. "sample.txt"))
  )

(deftest should-not-create-new-file []
  (is (false? (create-if-not-exists "existingfile.txt")))
  )


(deftest should-initialize-config-files []
  (initialize-config-files)
  (is (true? (.exists (File. "hs.user"))))
  )
