(ns tictactoe.game-spec
  (:use speclj.core)
  (:use tictactoe.game))

(describe "game"

  (it "adds an X marker to the board"
    (should= ["X" 2 3 4 5 6 7 8 9]
      (apply-move [1 2 3 4 5 6 7 8 9] "1")))

  (it "gets the current player marker"
    (should= "X" 
      (current-player [1 2 3 4 5 6 7 8 9])))

  (it "gets the current player marker"
    (should= "O" 
      (current-player ["X" 2 3 4 5 6 7 8 9])))

  (it "adds an X marker to the board"
    (should= ["X" 2 3 4 "O" 6 7 8 9]
      (apply-move ["X" 2 3 4 5 6 7 8 9] "5"))) 

(it "returns true when game is over"
    (should= true 
      (game-over? ["X" "O" 3 
                   "O" "X" "O" 
                   "X" "O" "X"])))

  (it "returns false when game is not over"
    (should= false 
      (game-over? [1 "O" 3 
                  "O" "X" "O" 
                  "X" "O" "X"])))  

  (it "returns nil when invalid"
    (should= nil 
      (valid-move? [1 2 3 4 5 6 7 8 9] "10"))))

  (it "returns true when valid"
    (should= true 
      (valid-move? [1 2 3 4 5 6 7 8 9] 7))) 

  (it "adds valid move to the board and returns the board"
    (should= [1 2 "X" 4 5 6 7 8 9] 
      (with-in-str "3"
        (next-move [1 2 3 4 5 6 7 8 9]))))

;; (defn get-user-input [& _]
;;   (let [input (first @fake-user-inputs)]
;;     (reset! fake-user-inputs rest)
;;     input))

;; (defn get-user-input [& _]
;;   (let [fake-user-inputs (atom ["a" 2])]
;;     (with-redefs [user-input (fn [& _]
;;       (let [input (first @fake-user-inputs)]
;;         (reset! fake-user-inputs rest)
;;                               user-input))])))
;;   
;; (it "adds valid move to the board and returns the board`"
;;    (should= [1 2 "X" 4 5 6 7 8 9] 
;;           (with-in-str (get-user-input (atom ["a" 2])) 
;;             (next-move [1 2 3 4 5 6 7 8 9]))))

  (it "adds valid move to the board and returns the board"
    (should= [1 2 "X" 4 5 6 7 8 9] 
      (with-in-str "3"
        (next-move [1 2 3 4 5 6 7 8 9])))) 
