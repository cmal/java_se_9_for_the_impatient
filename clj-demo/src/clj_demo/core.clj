(ns clj-demo.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(if true
  (do
    (prn 2)
    2))

(when true
  (prn 2)
  2)

(defn f [a]
  1)

(let [aa 1]
  aa)

aa
(defn f [a & b]
  [a b])

[1 '(2 3 4)]

(f 1 2 3 4)

(apply (fn [a & b] [a b]) [1 2 3 4])

(if nil 1 2)
(if false 1 2)
(if 0 1 2)
(if "" 1 2)


(when )

(cond
  false (prn 3)
  "" (+ 1 2)
  true (prn 2))

(range 5)

(let [x (range 5)]
  x)

(loop [x (range 5)]
  (if (empty? x)
    "end"
    (do
      (prn x)
      (recur (rest x)))))



