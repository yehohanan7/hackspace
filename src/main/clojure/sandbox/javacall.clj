(ns sandbox.javacall)

(println (com.hackspace.common.ClojureService/loopBack "look back message"))

(def service1 (new com.hackspace.common.ClojureService "key1"))
(def service2 (com.hackspace.common.ClojureService. "key2"))

(println "key for the service1 is" (.key service1))
(println "key for the service2 is" (.key service2))

(println "changing the service key......")

(.changeKey service1 "changedkey1")

(println "changed key for service1 is" (.key service1))

(set! (.user service1) "John")

(println "user for service 1" (.user service1))
