(ns looped-in-server.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [korma.core :as korma]
            [korma.db :as db]
            [clojure.java.io :as io]))

(db/defdb database
  (db/sqlite3 {:db (io/resource "looped-in.db")}))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
