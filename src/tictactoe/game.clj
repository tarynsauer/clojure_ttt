(ns tictactoe.game
  (:use tictactoe.board)
  (:use tictactoe.game)
  (:use tictactoe.ui))

(def player-types ["human", "computer"])

(def player-x (atom "human"))

(def player-o (atom "human"))

(defn update-player-x [player-type] 
  (reset! player-x player-type))

(defn update-player-o [player-type] 
  (reset! player-o player-type))

(defn valid-type? [input]
  (if (or (= (first player-types) input) (= (second player-types) input)) 
    (do true)
    (invalid-type-message input)))

(defn apply-player-type [player-type player-piece]
  (if (= player-piece (first piece))
    (update-player-x player-type)
    (update-player-o player-type)))
 
(defn set-player-type [piece]
  (let [player-type (get-player-type piece)]
     (if (valid-type? player-type) 
        (apply-player-type player-type piece)
        (recur piece))))

(defn current-player [board]
  (if (even? (count (filter string? board)))
    (first piece)
    (second piece)))

(defn current-player-type [board]
  (if (= (current-player board) "X")
    @player-x
    @player-o))

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
  (let [move (get-move (current-player board) board)]
        (if (valid-move? board move) 
          (apply-move board move)
          (recur board))))

(defn play [board]
  (set-player-type (first piece))
  (set-player-type (second piece)) 
  (loop [board board]
    (if (game-over? board)
      (game-over-message board (opponent board))
      (recur (next-move board)))))
