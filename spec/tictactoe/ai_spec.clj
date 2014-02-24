(ns tictactoe.ai-spec
  (:use speclj.core)
  (:use tictactoe.ai))

(describe "ai"

  (it "returns 1 for current player win"
    (should= 1
      (get-score ["X" "X" "X"
                  "O" "O" 6
                   7 8 9] "X")))

  (it "returns -1 for current player loss"
    (should= -1
      (get-score ["X" "X" "X"
                  "O" "O" 6
                   7 8 9] "O")))

  (it "returns 0 for non-winning board"
    (should= 0 
      (get-score ["X" "X" 3 
                  "O" "O" 6
                   7 8 9] "O")))

  (it "returns 0 for non-winning board"
    (should= 0 
      (get-score ["X" "X" 3 
                  "O" "O" 6
                   7 8 9] "O")))

  (it "returns 0 for non-winning board"
    (should= {3 0, 6 0, 7 0, 8 0, 9 0} 
      (open-cells-map ["X" "X" 3 "O" "O" 6 7 8 9])))


)
