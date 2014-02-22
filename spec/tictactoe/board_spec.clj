(ns tictactoe.board-spec
  (:use speclj.core)
  (:use tictactoe.board))

(describe "board"

  (it "returns empty gameboard"
    (should= [1 2 3 4 5 6 7 8 9]     
      (new-board 9)))

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

  (it "returns false for occupied cell"
    (should= false 
      (open-cell? [1 2 "X" 4 "O" 6 "O" 8 9] "3")))

  (it "returns true for open cell"
    (should= true 
      (open-cell? [1 2 "X" 4 "O" 6 "O" 8 9] "1")))

  (it "returns false for an invalid cell id type"
    (should= false 
      (valid-cell? "h")))

  (it "returns false for an invalid cell id number"
    (should= false 
      (valid-cell? "21")))

(it "returns true for a valid cell id number"
    (should= true 
      (valid-cell? "9")))

  (it "returns false when there are no remaining spaces"
    (should= false 
      (remaining-spaces? ["X" "O" "X" "O" "X" "O" "X" "O" "X"])))

  (it "returns true when there is a remaining space"
    (should= true 
      (remaining-spaces? ["X" "O" 3 "O" "X" "O" "X" "O" "X"])))

)



