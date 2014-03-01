(ns tictactoe.core
  (:use tictactoe.board)
  (:use tictactoe.ai) 
  (:use tictactoe.ui) 
  (:use tictactoe.game)
  (:gen-class :main true))

(defn -main []  
 (play (new-board 9) (get-player (first piece)) (get-player (second piece))))
