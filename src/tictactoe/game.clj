(ns tictactoe.game
  (:use tictactoe.board)
  (:use tictactoe.ui))
 
(defn current-player [board]
  (if (even? (count (filter string? board)))
    (first piece)
    (second piece)))

(defn opponent [board]
  (if (odd? (count (filter string? board)))
    (first piece)
    (second piece)))

(defn apply-move [board move]
  (assoc board (dec (read-string move)) (current-player board)))

(defn winning-game? [board]
  (or (winning-row? board) 
      (winning-col? board) 
      (winning-diag? board)))

(defn game-over? [board]
  (or (winning-game? board) 
      (not(remaining-spaces? board))))

(defn game-over-message [board piece]
  (if (winning-game? board) 
    (game-won-message piece board)
    (tie-game-message))) 

(defn valid-move? [board move]
  (if (and (valid-cell? move) (open-cell? board move))
    (do true)
    (invalid-move-message move)))

(defn next-move [board]
  (loop [board board]
    (let [move (get-move (current-player board) board)]
      (if (valid-move? board move)
        (apply-move board move)
        (recur board)))))  

(defn play [board]
  (loop [board board]
    (if (game-over? board)
      (game-over-message board (opponent board))
      (let [move (get-move (current-player board) board)]
        (if (valid-move? board move) 
          (recur (apply-move board move))
          (recur board))))))
