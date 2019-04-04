(ns clj-demo.ch08
  (:require [clojure.repl :refer [source doc]])
  (:import
   [java.util List ArrayList]
   [java.nio.file Files Paths]
   [java.nio.charset StandardCharsets]))

(as-> (String. (Files/readAllBytes (Paths/get "." (into-array ["finally.txt"])))
               StandardCharsets/UTF_8)
    $
  (.split $ "\n")
  (List/of $)) ;; due to CLJ-2284, this will not work


(= true
   (= (subsets #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
   (= (subsets #{}) #{#{}})
   (= (subsets #{1 2 3})
      #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
   (= (count (subsets (into #{} (range 10)))) 1024))

(defn to-binary [n d]
  (loop [cur d
         res []
         nn  n]
    (if (zero? nn)
      res
      (recur (quot cur 2)
             (conj res (= 1 (rem cur 2)))
             (dec nn)))))

(defn subset [s flags]
  (let [v (vec s)]
   (loop [a flags
          index 0
          res []]
     (if (empty? a)
       (set res)
       (recur
        (rest a)
        (inc index)
        (let [el (get v index)]
          (if (first a)
            (conj res el)
            res)))))))

(subset #{1 2 3} '(false true true))

(defn subsets [s]
  (letfn [(to-binary [n d]
            (loop [cur d
                   res []
                   nn  n]
              (if (zero? nn)
                res
                (recur (quot cur 2)
                       (conj res (= 1 (rem cur 2)))
                       (dec nn)))))
          (subset [s flags]
            (let [v (vec s)]
              (loop [a     flags
                     index 0
                     res   []]
                (if (empty? a)
                  (set res)
                  (recur
                   (rest a)
                   (inc index)
                   (let [el (get v index)]
                     (if (first a)
                       (conj res el)
                       res)))))))]
   (let [n      (count s)
         pow    (int (Math/pow 2 n))
         iter-n (iterate dec (dec pow))
         flags  (map (partial to-binary n)
                     iter-n)]
     (set (map (partial subset s) (take pow flags))))))

(subsets #{1 2 3})


(fn subsets [s]
  (letfn [(to-binary [n d]
            (loop [cur d
                   res []
                   nn  n]
              (if (zero? nn)
                res
                (recur (quot cur 2)
                       (conj res (= 1 (rem cur 2)))
                       (dec nn)))))
          (subset [s flags]
            (let [v (vec s)]
              (loop [a     flags
                     index 0
                     res   []]
                (if (empty? a)
                  (set res)
                  (recur
                   (rest a)
                   (inc index)
                   (let [el (get v index)]
                     (if (first a)
                       (conj res el)
                       res)))))))]
   (let [n      (count s)
         pow    (int (Math/pow 2 n))
         iter-n (iterate dec (dec pow))
         flags  (map (partial to-binary n)
                     iter-n)]
     (set (map (partial subset s) (take pow flags))))))
