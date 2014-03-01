(ns tictactoe.game
  (:use tictactoe.board)
  (:use tictactoe.ui)
  (:use tictactoe.ai))

(def player-types ["human" "computer" "ai"])

(defmulti get-move (fn [current-player board] (:player-type current-player)))

(def x-player {:piece "X" :player-type "human"})
(def o-player {:piece "O" :player-type "computer"})

(defmethod get-move "human" [current-player board]
  (get-human-move))

(defmethod get-move "computer" [current-player board]
  (get-random-move board))

(defmethod get-move "ai" [current-player board]
  (get-ai-move (:piece current-player) board))

(defn valid-type? [input]
  (if (or (= (first player-types) input) (= (second player-types) input) (= (last player-types) input)) 
    (do true)
    (invalid-type-message input)))

(defn get-player [piece]
  (let [player-type (get-player-type piece)]
     (if (valid-type? player-type) 
        (do {:piece piece :player-type player-type})       
        (recur piece))))

(defn game-over-message [board piece]
  (if (winning-game? board) 
    (game-won-message piece board)
    (tie-game-message board))) 

(defn filter-user-input [move]
  (try
    (read-string move)
    (catch Exception e)))

(defn valid-move? [board move]
  (let [move (filter-user-input move)]
    (if (and (valid-cell? move) (open-cell? board move))
      (do true)
      (invalid-move-message move))))

(defn get-computer-move [board]
  (get-random-move board))

(defn next-move [board player-x player-o]
  (player-move-message (current-piece board))
  (print-board board)
  (let [move (get-move (current-player board player-x player-o) board)]
        (if (valid-move? board move) 
          (apply-move board move)
          (recur board player-x player-o))))

(defn play [board player-x player-o]
  (loop [board board player-x player-x player-o player-o]
    (if (game-over? board)
      (game-over-message board (opponent board))
      (recur (next-move board player-x player-o) player-x player-o))))
