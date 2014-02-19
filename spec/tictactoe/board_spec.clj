(ns tictactoe.board-spec
  (:require [speclj.core :refer :all]
            [tictactoe.board :refer :all]))

(describe "board"

  (it "returns empty gameboard"
    (should= [1 2 3 4 5 6 7 8 9]     
      (new-board 9)))

  (it "adds an X marker to the board"
    (should= ["X" 2 3 4 5 6 7 8 9]
      (make-move [1 2 3 4 5 6 7 8 9] 1)))

  (it "gets the current player marker"
    (should= "X" 
      (current-player [1 2 3 4 5 6 7 8 9])))

  (it "gets the current player marker"
    (should= "O" 
      (current-player ["X" 2 3 4 5 6 7 8 9])))

  (it "adds an X marker to the board"
    (should= ["X" 2 3 4 "O" 6 7 8 9]
      (make-move ["X" 2 3 4 5 6 7 8 9] 5)))

  (it "returns true for top row winning game"
    (should= true 
      (winning-row? ["X" "X" "X" 4 5 6 7 8 9])))

  (it "returns true for middle row winning game"
    (should= true 
      (winning-row? [1 2 3 "X" "X" "X" 7 8 9])))

 (it "returns true for bottom row winning game"
    (should= true 
      (winning-row? [1 2 3 4 5 6 "O" "O" "O"])))

  (it "returns false for non-winning game"
    (should= false 
      (winning-row? [1 2 3 4 5 6 7 "X" "X"])))

  (it "returns true for first column winning game"
    (should= true
      (winning-col? ["X" 2 3 "X" 5 6 "X" 8 9])))

  (it "returns true for second column winning game"
    (should= true
      (winning-col? [1 "O" 3 4  "O" 6 7 "O" 9])))

  (it "returns true for third column winning game"
    (should= true
      (winning-col? [1 2 "X" 4 5 "X" 7 8 "X"])))

  (it "returns false for non-winning game"
    (should= false 
      (winning-col? [1 2 "X" 4 5 "O" 7 8 "X"])))

  (it "returns true for 1-5-9 winning diagonal"
    (should= true 
      (winning-diag? ["X" 2 3 4 "X" 6 7 8 "X"])))

  (it "returns true for 3-5-7 winning diagonal"
    (should= true 
      (winning-diag? [1 2 "O" 4 "O" 6 "O" 8 9])))

  (it "returns false for non-winning diagonal"
    (should= false 
      (winning-diag? [1 2 "X" 4 "O" 6 "O" 8 9])))

)



