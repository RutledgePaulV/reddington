(defproject org.clojars.rutledgepaulv/reddington "0.1.0-SNAPSHOT"

  :description
  "A collection of reader tags for enhanced local development."

  :url
  "https://github.com/rutledgepaulv/reddington"

  :license
  {:name "MIT" :url "http://opensource.org/licenses/MIT"}

  :deploy-repositories
  [["releases" :clojars]
   ["snapshots" :clojars]]

  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [criterium "0.4.5"]
   [me.alexpanov/free-port-finder "1.1.1"]
   [com.clojure-goes-fast/clj-async-profiler "0.4.0"]]

  :repl-options
  {:init-ns reddington.core})
