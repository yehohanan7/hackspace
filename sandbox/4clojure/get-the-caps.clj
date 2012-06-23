(ns sandbox.4clojure.get-the-caps)

;;(= (__ "HeLlO, WoRlD!") "HLOWRD")

;;(empty? (__ "nothing"))

;;(= (__ "$#A(*&987Zf") "AZ")

#(apply str (re-seq #"[A-Z]+" %))
