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
      (get-score ["O" "O" "O"
                  "X" "X" 6
                   "X" 8 9] "X")))

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

 (it "returns valid string id"
   (should= "1" 
     (get-ai-move [1 "X" "X"
                     4 "O" "O"
                     7 8 9 ] "X")))

 (it "returns valid string id for empty board"
   (should= "1" 
     (get-ai-move [1 2 3 
                   4 5 6 
                   7 8 9 ] "X")))

 (it "takes winning space when one is available"
   (should= 1 
     (get-best-move [1 "X" "X"
                     4 "O" "O"
                     7 8 9 ] "X")))

 (it "takes winning space when one is available"
   (should= 7 
     (get-best-move [1 "O" "X"
                     4 "X" "O"
                     7 8 9 ] "X")))

 (it "blocks opponent win"
   (should= 1 
     (get-best-move [1 "X" "X"
                     "X" "O" "O"
                     "O" "X" 9 ] "O")))

 (it "chooses win over block"
   (should= 4 
     (get-best-move [1 "X" "X"
                     4 "O" "O"
                     "O" "X" "X" ] "O")))

 (it "chooses win over block or non-win"
   (should= 4 
     (get-best-move [1 "O" "O"
                     4 "X" "X"
                     "X" 8 "O" ] "X")))

 (it "chooses block over multiple non-wins"
   (should= 1 
     (get-best-move [1 "O" "O"
                     4 5 "X"
                     "X" 8 9 ] "X")))

 (it "chooses corner with multiple sides available"
   (should= 1 
     (get-best-move [1 2 3 
                     4 "X" 6 
                     7 8 9 ] "O")))

 (it "chooses corner with multiple sides available"
   (should= 1 
     (get-best-move [1 "X" 3 
                     4 5 6 
                     7 8 9 ] "O")))

 (it "chooses win when same cell is block and win"
   (should= 1 
     (get-best-move [1 "X" "X" 
                     4 "O" 6 
                     7 "X" "O" ] "O")))

 (it "chooses center cell for the win"
   (should= 5 
     (get-best-move ["O" "X" "X" 
                     4 5 6 
                     7 "X" "O" ] "O")))

 (it "chooses pre-emptive block/win move"
   (should= 4 
     (get-best-move ["X" 2 "O" 
                     4 5 6 
                     7 8 9 ] "X")))

 (it "chooses pre-emptive block/win move"
   (should= 9 
     (get-best-move ["X" 2 "O" 
                     "O" 5 6 
                     "X" 8 9 ] "X")))

 (it "chooses middle for win"
   (should= 5 
     (get-best-move ["X" 2 "O" 
                     "O" 5 6 
                     "X" "O" "X" ] "X")))

 (it "chooses side for win"
   (should= 8 
     (get-best-move ["X" 2 "O" 
                     "O" "O" 6 
                     "X" 8 "X" ] "X")))

 (it "chooses corner for empty board"
   (should= 1 
     (get-best-move [1 2 3 
                     4 5 6 
                     7 8 9] "X")))

)
