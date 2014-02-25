(ns tictactoe.core-spec
  (:require clojure.contrib.string)
  (:use speclj.core)
  (:use tictactoe.board)
  (:use tictactoe.game))


(defn make-input [coll]
    (apply str (interleave coll (repeat "\n"))))  

(defn test-full-game [] 
  (set-player-type (first piece))
  (set-player-type (second piece))
  (play (new-board 9)))


