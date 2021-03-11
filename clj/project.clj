(defproject crux-in-a-box "0.0.1-SNAPSHOT"
  :description "Crux in a Box"

  :dependencies [[org.clojure/clojure "1.10.1"]

                 ;; required:
                 [juxt/crux-core "21.02-1.15.0-beta"]
                 [juxt/crux-rocksdb "21.02-1.15.0-beta"]

                 ;; logging:
                 [org.clojure/tools.logging "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [ch.qos.logback/logback-core "1.2.3"]
                 [org.slf4j/slf4j-api "1.7.30"]

                 ;; optional:
                 [juxt/crux-lucene "21.02-1.15.0-alpha"]
                 [juxt/crux-http-server "21.02-1.15.0-alpha"]]

  ;; logging:
  :jvm-opts ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory"])
