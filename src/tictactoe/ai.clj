(ns tictactoe.ai
  (:use tictactoe.board)
  (:use tictactoe.game))

(def win 1)

(def loss -1)

(def tie 0)

(def max-player-piece (atom "X"))

(def max-best-value (atom -999))

(def min-best-value (atom 999))

(defn get-score [board piece]
  (if (winning-game? board)
    (if (= (opponent board) piece)
      win 
      loss)
     tie)) 

(defn update-best-value [board piece depth]
  (let [score (/ (get-score board piece) depth)]
    (if (= piece @max-player-piece)
      (if (score > @max-best-value) (swap! max-best-value score))
      (if (score < @min-best-value) (swap! min-best-value score)))))

(defn apply-minimax [board, piece, depth]
  (loop [board board, piece piece, depth depth]
    (if (> depth 0) (update-best-value board piece depth))
    (if (game-over? board)
      (get-score board piece)
      (doseq [cell-id (filter integer? board)]  ;; if zero integers left, then return max/min best value
        (let [board (apply-move board (str cell-id))]
          (recur board (current-player board) (inc depth)))))))

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
