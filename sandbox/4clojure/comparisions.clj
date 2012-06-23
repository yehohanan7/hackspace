(fn [elems] (if (second elems) (recur (rest elems)) (first elems)))

(fn ultimate [x]
  (if (= (rest x) '())
    (first x) (ultimate (rest x))))

#(-> % reverse first)