(ns tictactoe.board)

(def piece ["X" "O"])

(def x-win (repeat 3 (first piece)))

(def o-win (repeat 3 (second piece)))

(defn new-board [total-cells] 
  (vec (range 1 (inc total-cells))))

(defn current-player [board]
  (if (even? (count (filter string? board)))
    (first piece)
    (second piece)))

(defn make-move [board i]
  (assoc board (dec i) (current-player board)))

(defn winning-row? [board]
  (loop [board board row []]
    (let [row (take 3 board)]
      (cond (or (= x-win row) (= o-win row))
        (do true)
        :else
        (if (empty? board)
          (do false)
          (recur (drop 3 board) []))))))

(defn winning-col? [board]
  (loop [begin-i 0 middle-i 3 end-i 6]
    (let [column (list (nth board begin-i) (nth board middle-i) (nth board end-i))]
      (cond (or (= x-win column) (= o-win column))
        (do true)
        :else
        (if (= (* 3 3) (inc end-i))
        (do false)
         (recur (inc begin-i) (inc middle-i) (inc end-i)))))))

(defn winning-diag? [board]
  (loop [begin-i 0 middle-i 4 end-i 8]
    (let [column (list (nth board begin-i) (nth board middle-i) (nth board end-i))]
      (cond (or (= x-win column) (= o-win column))
        (do true)
        :else
        (if (= 2 begin-i)
        (do false)
         (recur (+ 2 begin-i) middle-i (- end-i 2)))))))
