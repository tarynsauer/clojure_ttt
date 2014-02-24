(ns tictactoe.ui-spec
  (:use speclj.core)
  (:use tictactoe.ui))

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

  (it "prints player turn message"
    (should= "Player X - Make your move.\n" 
      (with-out-str (player-move-message "X"))))

  (it "prints invalid move message"
    (should= "9 is an invalid move.\n" 
      (with-out-str (invalid-move-message 9))))

  (it "prints gameover message"
    (should= "1 2 3\n4 5 6\n7 8 9\nGame over! Player X wins!\n" 
      (with-out-str (game-won-message "X" [1 2 3 4 5 6 7 8 9]))))

 (it "prints gameover message"
    (should= "1 2 3\n4 5 6\n7 8 9\nGame over! It's a tie!\n" 
      (with-out-str (tie-game-message [1 2 3 4 5 6 7 8 9]))))

  (it "gets cell number from human player"
    (should= "3" 
      (with-in-str "3"
        (get-human-move "X" [1 2 3 4 5 6 7 8 9]))))

  (it "prints select player type message"
    (should= "For player X - Enter 'human' or 'computer' for player type.\n"
    (with-out-str (get-player-type-message "X"))))
)

