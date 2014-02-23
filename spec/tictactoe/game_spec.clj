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
  
 (it "gets the current player's opponent's  marker"
    (should= "X" 
      (opponent ["X" "X" "X" 4 5 6 7 "O" "O"])))

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
      (valid-move? [1 2 3 4 5 6 7 8 9] "10")))

  (it "returns true when valid"
    (should= true 
      (valid-move? [1 2 3 4 5 6 7 8 9] "7"))) 

  (it "adds valid move to the board and returns the board"
    (should= [1 2 "X" 4 5 6 7 8 9] 
      (with-in-str "3"
        (next-move [1 2 3 4 5 6 7 8 9]))))

  (it "adds valid move to the board and returns the board"
    (should= [1 2 "X" 4 5 6 7 8 9] 
      (with-in-str "3"
        (next-move [1 2 3 4 5 6 7 8 9])))) 

  ;; (def uniq-id (atom 1))
  ;; (defn get-next [] (swap! uniq-id inc))

  ;; (it "adds invalid value and then a valid value"
  ;;   (should= ["X" "O" 3 4 5 6 7 8 9] 
  ;;     (with-in-str (str (get-next)) 
  ;;       (next-move ["X" 2 3 4 5 6 7 8 9]))))

  (it "returns true when player type is valid"
    (should= true 
      ( valid-type? "human")))

  (it "returns true when player type is valid"
    (should= true 
      ( valid-type? "computer")))

  (it "returns nil when player type is invalid"
    (should= nil 
      ( valid-type? "x")))

  (it "sets player type for player X"
    (should= "computer" 
      (apply-player-type "computer" "X")))

  (it "sets player type for player O"
    (should= "human" 
      (apply-player-type "human" "O")))

  (it "sets player type for player O"
    (should= "human" 
      (with-in-str "human"
        (set-player-type "O"))))

  (it "returns current player type"
    (should= "human" 
      (current-player-type ["X" 2 3 4 5 6 7 8 9])))

)
