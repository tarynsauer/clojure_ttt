(ns tictactoe.game-spec
  (:require [speclj.core :refer :all]
            [tictactoe.game :refer :all]))

(describe "game"

  (it "adds an X marker to the board"
    (should= ["X" 2 3 4 5 6 7 8 9]
      (apply-move [1 2 3 4 5 6 7 8 9] 1)))

  (it "gets the current player marker"
    (should= "X" 
      (current-player [1 2 3 4 5 6 7 8 9])))

  (it "gets the current player marker"
    (should= "O" 
      (current-player ["X" 2 3 4 5 6 7 8 9])))

  (it "adds an X marker to the board"
    (should= ["X" 2 3 4 "O" 6 7 8 9]
      (apply-move ["X" 2 3 4 5 6 7 8 9] 5))) 

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
)

