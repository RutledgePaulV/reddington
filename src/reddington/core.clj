(ns reddington.core
  (:require [clj-async-profiler.core :as cap]
            [clojure.pprint :as pprint]
            [criterium.core :as crit])
  (:import (me.alexpanov.net FreePortFinder)
           (java.awt Desktop Desktop$Action Toolkit Dimension)
           (java.net URI)))


(defonce profile-server
  (delay
    (let [port (FreePortFinder/findFreeLocalPort)]
      (cap/serve-files port)
      port)))

(defonce dimensions
  (delay
    (let [toolkit (Toolkit/getDefaultToolkit)]
      (if-some [dimension
                ^Dimension
                (try
                  (.getScreenSize toolkit)
                  (catch Exception e nil))]
        {:width  (.-width dimension)
         :height (quot (.-height dimension) 40)}
        {}))))

(defn open-url [url]
  (when (Desktop/isDesktopSupported)
    (let [desktop (Desktop/getDesktop)]
      (when (.isSupported desktop Desktop$Action/BROWSE)
        (.browse desktop (URI. url))))))

(defn pp* [form]
  `(let [result# (do ~form)]
     (pprint/pprint result#)
     result#))

(defn bench [form]
  `(crit/with-progress-reporting
     (crit/quick-bench ~form)))

(defn prof [form]
  `(let [dims# (force dimensions)
         port# (force profile-server)]
     (try
       (cap/start {:interval 100000})
       (do ~form)
       (finally
         (let [flame# (cap/stop (merge dims# {}))]
           (open-url (format "http://localhost:%d/%s" port# (.getName flame#))))))))
