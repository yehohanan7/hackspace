(defproject com.hackspace "1.0.0-SNAPSHOT"
  :description "hack free cloud space"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [clj-oauth/clj-oauth "1.3.1-SNAPSHOT"]
                 [com.dropbox/dropbox-java-sdk "1.3.1"]
                 [org.clojure/tools.cli "0.2.1"]
                 [com.dropbox/json_simple "1.1"]

                 [com.dropbox/httpmime "4.1.3"]
                 [commons-logging/commons-logging "1.1.1"]
                 [clj-http "0.1.3"]
                 [oauth.signpost/signpost-core "1.2.1.2"]
                 [oauth.signpost/signpost-commonshttp4 "1.2.1.2"]
                 [org.clojure/data.json "0.1.2"]
                 ]
  :dev-dependencies [[midje "1.4.0"]]
  :source-paths ["src"]
  :test-paths ["test"]
  :main com.hackspace.main)