(ns tictactoe.ui-spec
  (:require [speclj.core :refer :all]
            [tictactoe.ui :refer :all]))

(describe "ui"
  (around [it]
    (with-out-str (it)))

  (it "prints an empty gameboard"
    (should= "1 2 3\n4 5 6\n7 8 9\n" 
      (with-out-str (print-board [1 2 3 4 5 6 7 8 9]))))

  (it "prints an in-progress gameboard"
    (should= "1 X 3\n4 5 O\n7 8 X\n" 
      (with-out-str (print-board [1 "X" 3 4 5 "O" 7 8 "X"]))))

  (it "gets cell number from human"
    (should= "1 X 3\n4 5 O\n7 8 X\n" 
      (with-out-str (print-board [1 "X" 3 4 5 "O" 7 8 "X"]))))

)



