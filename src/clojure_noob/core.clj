(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(println "Cleanliness is next to godliness")

(defn train
  []
  (println "Choo choo!"))

(+ 1 (* 2 3) 4)

(if true "By Zeus's hammer!" "By Aquaman's trident!")

(if false 
    "By Zeus's hammer!"
  "By Aquaman's trident!")

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))
  
(when true 
  (println "Success!")
  "abra cadabra")

(nil? 1)

(nil? nil)

(if "bears eat beets"
  "bears beets Battlestar Galactica")

(if nil 
  "This Won't be the result because nil is falsey"
  "nil is falsey")

(= 1 1)

(= nil nil)

(= 1 2)

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)

(or (= 0 1) (= "yes" "no"))

(or nil)

(and :free_wifi :hot_coffee)


(and :feelin_super_cool nil false)

(def failed-protagonist-names 
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOMEEED!")))

(error-message :blarght)

(def name4 "Chewbacca")
name4

(str "\"Uglglglglgllglgllllll\" - " name4)

{:first-name "Charlie"
 :last-name "McFishwich"}

{"string-key" +}

{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}

(hash-map :a 1 :b 2)

(get {:a 0 :b 1} :b)

(get {:a 0 :b {:c "ho hum"}} :b)

({:name "The Human Coffeepot"} :name)

(:a {:a 1 :b 2 :c 3})

(get {:a 1 :b 2 :c 3} :a)

(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")

[3 2 1]

(get [3 2 1] 0)
;vectors start from 0. "0-indexed colletion"

(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

(vector "creepy" "full" "moon")

(conj [1 2 3] 4)
;=>[1 2 3 4] yeeey like clojure/conj get it? let's get all together
; conj adds to the end of the vector!

'(1 2 3 4)

(nth '(:a :b :c) 0)
;equivalent of get for lists

(nth '(:a :b :c) 2)
;nth is slower to retrieve element from list than from vector
; but list is more effective memorywise? vector is indexed...
; list is like linked-list from SICP?

(list 1 "two" {3 4})

(conj '(1 2 3 4) 5)

;=> (5 1 2 3 4) conj adds to the beginning of the list!
;list=good access for beggining (adding/reading) and macroessss
;otherwise indexed vector

#{"kurt vonnegut" 20 :icicle}
;sorted set (unique values!)

(hash-set 1 1 2 2)

(conj #{:a :b} :b)
; #{:b :a}
;don't forget the difference () vs {}
;why is it not sorted?

(set [3 3 3 4 4])
;strange behaviour? why is the answer #(4 3)???

(contains? #{:a :b} :a)

(contains? #{:a :b} 3)

(:a #{:a :b})

(get #{:a :b} :a)

(get #{:a nil} nil)
;always nilllll =)))))))))
; better use contains?

(get #{:a :b} "kurt vonnegut")

;p48

((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)

((first [+ 0]) 1 2 3)

(inc 1.1)

(map inc [0 1 2 3])
;note that map returns list => (1 2 3 4)

(+ (inc 199) (/ 100 (- 7 2)))


(+ 200 (/ 100 (- 7 2)))
;left to right

(+ 200 (/ 100 5))

(+ 200 20)

;*defn
;*function name
;*docstring describing the function
;*parameters listed in brackets
;*function body

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))
; function calls itself when only 1 argument given
; 1 agrument is  default "karate" chop wow fun!

(x-chop "Kayne West" "slap")

(x-chop "Kayne East")
;default value for slap is karate in case only argument ot a function

;p54

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kayne West" "slap")

(x-chop "Kayne East")

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

;; & is a way to make variable arity function
;; & whippersnappers is a rest parameter "put the rest of these arguments in a list with the following name"
;; rest parameters have to come last

(codger "Billy" "Anne-Marie" "The Incredible Bulk")

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreem" "gum" "shoes" "kara-te")

;;destructuring

(defn my-first
  [[first-thing]] first-thing)
;;first thing is withing a vector

(my-first ["oven" "bike" "war-axe"])
;; "oven"

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. " "Here they are in case you need to cry over them: "
(clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

;;p55

(defn announce-treasure-location-shrt
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location-shrt {:lat 50 :lng 100})

(defn receive-treasure-location
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng))
  (println  treasure-location))
;; :as gives a reference for the original map so you can call it or manipulate it like (sail-ship! treasure-location)

(receive-treasure-location {:lat 100 :lng 88})

;; In general, you can think of destructuring as instructing Clojure on
;;how to associate names with values in a list, map, set, or vector.

(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")

(illustrative-function)
;; => joe returned

(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 5)

(number-comment 7)

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo"])

((fn [x] (* x 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))

(my-special-multiplier 12)

;; Surprise! anonymous function given a name ;)))

(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo"])

;; different arguments like %1 %2 %3 etc

(#(str %1 " and " %2) "cornbread" "butter beans")

;; passing rest parameter with %&

(#(identity %&) 1 "blarg" :yip)

;; identity returns argument without altering it
;; _rest_ arguments are stored as lists so we get a list

;;p58

;;functions return other functions... returned functions are closures which means that they can access all the variables that were in scope when the function was created

(defn inc-maker
  "Create a custom incrementator"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-") :size (:size part)})
(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let  [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))
   ))
;; you have to read loop & let bindings in pairs
;; remaining-asym-parts=asym-body-parts
;; final-body-parts= empty vector []

;; destructuring also works...

;; recur remaining etc. splits the sequence into head and tail then it processes the head, adds  it to some result and uses recursion to continue the process with the tail
(symmetrize-body-parts asym-hobbit-body-parts)


;;p61

(def dalmatian-list 
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(let [dalmatians (take 2 dalmatian-list)]
dalmatians)

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))

;;p65

;; sum with reduce

(reduce + [1 2 3 4])
;; equivalent to 
(+ (+ (+ 1 2) 3) 4)
;; first two elements of the sequence then next then next etc
(reduce + 15 [1 2 3 4])
;; optional initial value
;; then reduce takes 15 + 1 on first step

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(rest [1 2 3 4])

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(better-symmetrize-body-parts asym-hobbit-body-parts)

;;spider expander homework

;;p67
