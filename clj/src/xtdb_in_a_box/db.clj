(ns xtdb-in-a-box.db
  (:require [clojure.java.io :as io]
            [xtdb.api :as xt]))

(println (System/getenv "XTDB_ENABLE_BYTEUTILS_SHA1"))

(defn start-xtdb! []
  (letfn [(kv-store [dir]
            {:kv-store {:xtdb/module 'xtdb.rocksdb/->kv-store
	                      :db-dir      (io/file dir)
                        :sync?       true}})]
    (xt/start-node
     {:xtdb/tx-log              (kv-store "data/dev/tx-log")
	    :xtdb/document-store      (kv-store "data/dev/doc-store")
      :xtdb/index-store         (kv-store "data/dev/index-store")
      ;; optional:
      :xtdb.lucene/lucene-store {:db-dir "data/dev/lucene-dir"}
      :xtdb.http-server/server  {:port 9999}})))

(def xtdb-node (start-xtdb!))

(defn stop-xtdb! []
  (.close xtdb-node))
