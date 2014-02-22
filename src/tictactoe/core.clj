(ns tictactoe.core
  (:require [clojure.java.io :as io])
  (:use tictactoe.board)
  (:use tictactoe.ui) 
  (:use tictactoe.game)
  (:gen-class :main true))

(defn -main [] 
  (play (new-board 9)))


