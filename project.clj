(defproject reddington "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [criterium "0.4.5"]
                 [me.alexpanov/free-port-finder "1.1.1"]
                 [com.clojure-goes-fast/clj-async-profiler "0.4.0"]]
  :repl-options {:init-ns reddington.core})