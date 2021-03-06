(defproject tictactoe "1.0.1"
  :description "Tictactoe application with AI"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"] [org.clojure/tools.cli "0.3.1"]]
  :profiles {:dev {:dependencies [[speclj "2.9.1"]]}}
  :plugins [[speclj "2.9.1"] [speclj-growl "1.0.0-SNAPSHOT"]]
  :test-paths ["spec"]
  :main tictactoe.core
  :java-source-path "src/")
