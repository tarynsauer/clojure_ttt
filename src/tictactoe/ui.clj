(ns tictactoe.ui)

(defn print-board [board]
  (println (nth board 0) (nth board 1) (nth board 2))
  (println (nth board 3) (nth board 4) (nth board 5))
  (println (nth board 6) (nth board 7) (nth board 8))) 
