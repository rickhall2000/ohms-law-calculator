(defproject ohms-law-calculator "0.1.0-SNAPSHOT"
  :description "A small demonstraction of using ClojureScript"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [domina "1.0.2-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :source-paths ["src/clj"]
  :cljsbuild {:crossovers [ohms-law-calculator.core]
              :builds
              {:dev  {
                 :source-paths ["src/cljs" "src/brepl"]
                 :compiler {
                            :output-to "resources/public/js/ohmslaw_dbg.js"
                            :optimizations :whitespace
                            :pretty-print true
                            }
                      }
               :prod  {
                 :source-paths ["src/cljs"]
                 :compiler {
                            :output-to "resources/public/js/ohmslaw.js"
                            :optimizations :advanced
                            }
                 }
               }})
