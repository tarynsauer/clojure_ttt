(ns tictactoe.ui)

(defn print-board [board]
  (println (nth board 0) (nth board 1) (nth board 2))
  (println (nth board 3) (nth board 4) (nth board 5))
  (println (nth board 6) (nth board 7) (nth board 8))) 

(defn player-move-message [piece]
  (println "Player" piece "- Make your move."))

(defn invalid-move-message [move]
  (println  move "is an invalid move."))

(defn game-won-message [piece board]
  (println "Game over! Player" piece "wins!")
  (print-board board))

(defn tie-game-message [board]
  (println "Game over! It's a tie!")
  (print-board board))

(defn get-human-move []
  (read-line))

(defn get-player-type-message [piece]
  (println "For player" piece "- Enter 'human' or 'computer' or 'ai' for player type."))

(defn get-player-type [piece]
  (get-player-type-message piece)
  (read-line)) 

(defn invalid-type-message [input]
  (println input "is an invalid type."))
