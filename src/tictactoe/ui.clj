(ns tictactoe.ui)

(defn print-board [board]
  (println (nth board 0) (nth board 1) (nth board 2))
  (println (nth board 3) (nth board 4) (nth board 5))
  (println (nth board 6) (nth board 7) (nth board 8))) 

(defn player-move-message [piece]
  (println "Player" piece "- Make your move."))

(defn invalid-move-message [move]
  (println  move "is an invalid move."))

(defn game-over-message [game-outcome]
  (println "Game over!" game-outcome))

(defn get-move [piece]
  (println player-move-message [piece])
  (read-line))
