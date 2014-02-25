(ns tictactoe.game-spec
  (:use speclj.core)
  (:use tictactoe.core-spec)
  (:use tictactoe.board)
  (:use tictactoe.core)
  (:use tictactoe.game))

 (describe "game"

  (it "should play out a human versus human game"
    (should= "Player X wins!"
     (re-find #"Player X wins!"
      (with-out-str 
        (with-in-str 
          (make-input '("human" "human" "1" "2" "3" 
                        "4" "5" "6" "7" "8" "9")) (test-full-game))))))

  (it "should play out an ai versus ai game"
    (should= "Game over! It's a tie!"
     (re-find #"Game over! It's a tie!"
      (with-out-str 
        (with-in-str 
          (make-input '("ai" "ai")) (test-full-game))))))

  (it "should play out a human versus ai game"
    (should= "Game over! It's a tie!"
     (re-find #"Game over! It's a tie!"
      (with-out-str 
        (with-in-str 
          (make-input '("human" "ai" "1" "4" "3" "8" "9")) (test-full-game))))))

  (it "should play out a computer versus computer game"
    (should= "Game over!"
     (re-find #"Game over!"
      (with-out-str 
        (with-in-str 
          (make-input '("computer" "computer")) (test-full-game))))))

  (it "should play out a computer versus ai game"
    (should= "Game over!"
     (re-find #"Game over!"
      (with-out-str 
        (with-in-str 
          (make-input '("computer" "ai")) (test-full-game))))))



) 
