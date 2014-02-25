(ns tictactoe.ai
  (:use tictactoe.board)
  (:use tictactoe.game))

(declare alphabeta)

(def win 1)

(def loss -1)

(def tie 0)

(def max-player-piece (atom "X"))

(def neg-inf -999)

(def pos-inf 999)

(defn get-score [board piece]
  (if (winning-game? board)
    (if (= (opponent board) piece)
      win 
      loss)
     tie)) 

(defn apply-minimax [board, piece, depth]
  (if (game-over? board)
    (get-score board piece)
    (if (= piece @max-player-value)
      (apply min (minimax board, piece, depth)) 
      (apply max (minimax board, piece, depth)))))

(defn minimax [board, piece, depth, best-score []]
  (doseq [cell-id (filter integer? board)]
    (let [score (/ (apply-minimax (apply-move board (str cell-id)), piece, (inc depth)) depth)]
      (conj best-score score))))

(defn get-move-score [board, piece, cell]
   (let [board (apply-move board (str cell)), depth 0] 
     (apply-minimax board, piece, depth)))
 
(defn rank-possible-moves [board piece]
  (let [possible-moves (filter integer? board), scores {}]
    (doseq [cell-id possible-moves] 
      (assoc scores cell-id (get-move-score board, piece, cell-id)))))
 
(defn get-best-move [board piece]
  (key (apply max-key val (rank-possible-moves board piece)))) 

(defn apply-ai-move [board piece]
  (reset! max-player-piece piece)
  (apply-move board (str (get-best-move board piece))))
