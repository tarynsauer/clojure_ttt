(ns tictactoe.ai
  (:use tictactoe.board)
  (:use tictactoe.game))

(declare minimax)

(def win 1)

(def loss -1)

(def tie 0)

(def current-player-piece (atom "X"))

(defn get-score [board piece]
  (if (winning-game? board)
    (if (= (opponent board) @current-player-piece)
      win 
      loss)
     tie)) 

(defn apply-minimax [board, piece, depth]
  (if (game-over? board)
    (get-score board piece)
    (let [best-scores (vec (minimax board, piece, depth))]
      (if (= piece @current-player-piece)
        (apply min best-scores)
        (apply max best-scores)))))

(defn minimax [board, piece, depth]
  (for [cell-id (filter integer? board)] (/ (apply-minimax (apply-move board (str cell-id)), (current-player board) , (inc depth)) depth)))

(defn get-move-score [board, piece, cell]
   (let [board (apply-move board (str cell)), depth 1] 
     (apply-minimax board, piece, depth)))
 
(defn rank-possible-moves [board piece]
  (let [possible-moves (filter integer? board)]
    (for [cell possible-moves] 
      (get-move-score board, piece, cell))))
 
(defn get-best-move [board piece]
  (reset! current-player-piece piece) 
  (key (apply max-key val (reverse (into {} (map vector (vec (filter integer? board)) (vec (rank-possible-moves board piece))))))))

(defn apply-ai-move [board piece]
  (apply-move board (str (get-best-move board piece))))
