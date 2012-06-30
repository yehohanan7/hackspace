(ns com.hackspace.oauthtest
  (:use midje.sweet))

(require '[clj-http.client :as client])
(require '(com.hackspace [oauth :as oauth]))

(import '(com.dropbox.client2 DropboxAPI))



(fact "should generate a oauth url signature"
  (oauth/generate-signature "url" "GET" "key1=value1&key2=value2") => #(not (nil? %))

  ;;(provided
  ;;  (fileutils/exists? user-file) => false)
  )