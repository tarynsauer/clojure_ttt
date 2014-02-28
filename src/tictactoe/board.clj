(ns tictactoe.board)

(def piece ["X" "O"]) 

(def x-win (repeat 3 (first piece)))

(def o-win (repeat 3 (second piece)))

(defn filter-printable [obj]
  (cond
   (or (symbol? obj) (number? obj) (string? obj) (keyword? obj)) obj
   (vector? obj) (apply vector (map filter-printable obj))
   (seq? obj) (map filter-printable obj)
   (set? obj) (into #{} (map filter-printable obj))
   (map? obj) (into {} (for [[k v] obj]
                         [(filter-printable k) (filter-printable v)]))
   true [:un-readable (pr-str obj)]))

(defn open-cells [board]
  (filter integer? board)) 

(defn get-random-move [board]
  (str (first (filter integer? (shuffle board)))))

(defn current-player [board]
  (if (even? (count (filter string? board)))
    (first piece)
    (second piece)))

 (defn opponent [board]
  (if (odd? (count (filter string? board)))
    (first piece)
    (second piece)))

 (defn apply-move [board move]
  (assoc board (dec (read-string move)) (current-player board))) 

(defn empty-board? [board]
  (= 9 (count (filter integer? board))))

(defn new-board [total-cells] 
  (vec (range 1 (inc total-cells))))

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

(defn open-cell? [board cell]
  (integer? (get board (dec (filter-printable cell)))))

(defn valid-cell? [cell]
  (and (integer? (filter-printable cell)) (< 0 (filter-printable cell)) (> 10 (filter-printable cell))))

(defn remaining-spaces? [board]
  (loop [index 0]
    (let [cell (get board index)]
      (if (integer? cell)
        (do true)
        (if (= 8 index)
          (do false)
           (recur (inc index)))))))

(defn winning-game? [board]
  (or (winning-row? board) 
      (winning-col? board) 
      (winning-diag? board)))

(defn game-over? [board]
  (or (winning-game? board) 
      (not(remaining-spaces? board))))
