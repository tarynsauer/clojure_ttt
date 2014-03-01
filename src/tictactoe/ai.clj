(ns tictactoe.ai
  (:use tictactoe.board))

(declare minimax)

(def win 1)

(def loss -1)

(def tie 0)

(defn get-score [current-player-piece board]
  (if (winning-game? board)
    (if (= (opponent board) current-player-piece)
      win 
      loss)
     tie)) 

(defn apply-minimax [current-player-piece, board, depth]
  (if (game-over? board)
    (get-score current-player-piece board)
    (let [best-scores (vec (minimax current-player-piece, board, depth))]
      (if (= (opponent board) current-player-piece)
        (apply min best-scores)
        (apply max best-scores)))))

(defn minimax [current-player-piece, board, depth]
  (for [cell (open-cells board)] (/ (apply-minimax current-player-piece (apply-move board (str cell)), (inc depth)) depth)))

(defn get-move-score [current-player-piece, board, cell]
   (let [board (apply-move board (str cell)), depth 1] 
     (apply-minimax current-player-piece, board, depth)))
 
(defn rank-possible-moves [current-player-piece board]
  (let [possible-moves (open-cells board)]
    (for [cell possible-moves] 
      (get-move-score current-player-piece, board, cell))))
 
(defn get-best-move [current-player-piece board]
    (key (apply max-key val (reverse (into {} (map vector (vec (open-cells board)) (vec (rank-possible-moves current-player-piece board))))))))

(defn get-ai-move [current-player-piece  board]
  (if (empty-board? board)
    (get-random-move board) 
    (str (get-best-move current-player-piece board))))
