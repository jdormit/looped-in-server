(ns looped-in-server.migrations
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(defn load-config []
  {:datastore (jdbc/sql-database {:connection-uri "jdbc:sqlite:resources/looped-in.db"})
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))

(defn rollback []
  (repl/rollback (load-config)))
