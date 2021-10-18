(defproject xtdb-in-a-box "0.0.2"
  :description "XTDB in a Box"

  :dependencies [[org.clojure/clojure "1.10.1"]

                 ;; required:
                 [com.xtdb/xtdb-core "1.19.0"]
                 [com.xtdb/xtdb-rocksdb "1.19.0"]

                 ;; logging:
                 [org.clojure/tools.logging "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.3"]
                 [ch.qos.logback/logback-core "1.2.3"]
                 [org.slf4j/slf4j-api "1.7.30"]

                 ;; optional:
                 [com.xtdb/xtdb-lucene "1.19.0"]
                 [com.xtdb/xtdb-http-server "1.19.0"]]

  ;; XTDB SHA1 workaround for JDK 17 on MacOS:
  :plugins [[lein-with-env-vars "0.2.0"]]

  ;; logging:
  :jvm-opts ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory"
             ;; the following option is required for JDK 16 and 17:
             ;; https://github.com/xtdb/xtdb/issues/1462
             "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED"]

  ;; the following implements the XTDB SHA1 workaround for JDK 17 on MacOS:
  :hooks [leiningen.with-env-vars/auto-inject]
  :env-vars {:XTDB_ENABLE_BYTEUTILS_SHA1 "true"})
