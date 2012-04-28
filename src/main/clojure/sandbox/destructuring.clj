(def guys-whole-name ["Vincent" "John" "Pradeep"])

(println (str (nth guys-whole-name 1) ", " (nth guys-whole-name 2) ", " (nth guys-whole-name 0)))

(let [[surname firstname middlename] guys-whole-name ]
  (println firstname ", " middlename ", " surname)
  
  )


(let   [[a b c & others] (range 10)]
  (println "a b c are: " a b c)
  (println "others: " others)
  )


(let [[a b c & others :as all] (range 10)]
  (println all)
  )

(def myname {:first-name "John" :middle-name "Pradeep" :lastname "Vincent"})

(let [{first :first-name middle :middle-name last :lastname} myname]
 (println "firstname: " first)
  (println "middlename: " middle)
  (println "lastname: " last)
  )

(let [{first 1, second 2} [0 1 2]]
  (println "first: " first)
  (println "second: " second)
  )


(let [{:keys [first-name middle-name lastname title], :or {title "Mr."}} myname ]
   (println "firstname: " first-name)
  (println "middlename: " middle-name)
  (println "lastname: " lastname)
  (println "title: " title)
  )




