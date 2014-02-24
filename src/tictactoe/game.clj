(ns tictactoe.game
  (:use tictactoe.board)
  (:use tictactoe.ui))

(def x-player-type (atom "human"))
(def o-player-type (atom "human"))

(def player-types ["human" "computer" "ai"])

(defn current-player [board]
  (if (even? (count (filter string? board)))
    (first piece)
    (second piece)))

(defn current-player-type [board]
  (if (= (current-player board) (first piece))
     @x-player-type 
     @o-player-type))

(defn opponent [board]
  (if (odd? (count (filter string? board)))
    (first piece)
    (second piece)))
 
(defn update-player-types [player-piece new-type] 
  (if (= player-piece (first piece))
    (reset! x-player-type new-type)
    (reset! o-player-type new-type)))

(defn valid-type? [input]
  (if (or (= (first player-types) input) (= (second player-types) input) (= (last player-types) input)) 
    (do true)
    (invalid-type-message input)))

(defn set-player-type [piece]
  (let [player-type (get-player-type piece)]
     (if (valid-type? player-type) 
        (update-player-types piece player-type)
        (recur piece))))

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

(defn get-computer-move [board]
  (str (first (filter integer? (shuffle board)))))

(defn get-move [piece board]
  (if (= (current-player-type board) (first player-types))
    (get-human-move piece board)
    (get-computer-move board)))

(defn next-move [board]
  (let [move (get-move (current-player board) board)]
        (if (valid-move? board move) 
          (apply-move board move)
          (recur board))))

(defn play [board]
  (loop [board board]
    (if (game-over? board)
      (game-over-message board (opponent board))
      (recur (next-move board)))))
