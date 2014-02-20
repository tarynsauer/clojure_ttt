(ns tictactoe.game
  (:require [tictactoe.board :refer :all]))
 
(defn current-player [board]
  (if (even? (count (filter string? board)))
    (first piece)
    (second piece)))

(defn apply-move [board i]
  (assoc board (dec i) (current-player board)))
 
(defn game-over? [board]
  (or (winning-row? board) 
      (winning-col? board) 
      (winning-diag? board)
      (not(remaining-spaces? board))))
