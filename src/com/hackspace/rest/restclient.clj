(ns com.hackspace.rest.restclient
  (:require [clj-http.client :as http]))


(defn accessible? [url]
  (println (= (:status (http/get url)) 200))
  )




(accessible? "http://google.com")