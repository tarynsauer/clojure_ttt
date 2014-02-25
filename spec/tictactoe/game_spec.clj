(ns tictactoe.game-spec
  (:use speclj.core)
  (:use tictactoe.core-spec)
  (:use tictactoe.game))

(describe "game"

  (it "returns nil when invalid"
    (should= nil 
      (valid-move? [1 2 3 4 5 6 7 8 9] "10")))

  (it "returns true when valid"
    (should= true 
      (valid-move? [1 2 3 4 5 6 7 8 9] "7"))) 
  
  (it "returns true for human player type"
    (should= true 
      ( valid-type? "human")))

  (it "returns true for computer player type"
    (should= true 
      ( valid-type? "computer")))
  
  (it "returns true for ai player type"
    (should= true 
      ( valid-type? "ai")))

  (it "returns nil when player type is invalid"
    (should= nil 
      ( valid-type? "x")))

  (it "sets player type for player X"
    (should= "computer" 
      (update-player-types "X" "computer")))

  (it "sets player type for player O"
    (should= "human" 
      (update-player-types "O" "human")))

  (it "sets player type for player X"
    (should= "computer" 
      (with-in-str "computer"
        (set-player-type "X"))))

  (it "sets player type for player O"
    (should= "human" 
      (with-in-str "human"
        (set-player-type "O"))))

  (it "should reject an invalid player type"
    (should= "human"
      (with-in-str (make-input '("batman" "best type" "human"))
        (set-player-type "X"))))

  (it "returns current player type"
    (should= "human" 
      (current-player-type ["X" 2 3 4 5 6 7 8 9])))

  (it "returns an available cell id"
    (should= "2" 
      (get-computer-move ["X" 2 "O" "X" "O" "X" "O" "X" "O"])))

   (it "returns a random cell id"
    (should= true 
      (string? (get-computer-move [1 2 3 4 5 6 7 8 9]) )))

  (it "adds valid move to the board and returns the board"
    (should= ["X" 2 "O" 4 5 6 7 8 9] 
      (with-in-str "3"
       (next-move ["X" 2 3 4 5 6 7 8 9]))))

  (it "adds valid move to the board and returns the board"
    (should= ["X" 2 "O" 4 5 6 7 8 9] 
      (with-in-str "3"
        (next-move ["X" 2 3 4 5 6 7 8 9]))))
)
