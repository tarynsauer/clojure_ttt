(ns tictactoe.core
  (:require [clojure.java.io :as io])
  (:use tictactoe.board)
  (:use tictactoe.ui) 
  (:use tictactoe.game)
  (:gen-class :main true))

(defn -main [] 
  (set-player-type (first piece))
  (set-player-type (second piece))
  (play (new-board 9)))
