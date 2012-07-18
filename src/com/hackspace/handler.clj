(ns com.hackspace.handler)

(require '(com.hackspace.utils [fileutils :as fileutils]))
(use '[clojure.string :only (join split)])

(defmulti handle #(first %&))

(defmethod handle :get [_ data file-name]
  (let [file (last (split file-name #"/")) _ (fileutils/create-if-not-exists file)]
    (fileutils/write-content data file)
    )
  )


