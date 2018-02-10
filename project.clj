(defproject looped-in-server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [korma "0.4.3"]
                 [org.xerial/sqlite-jdbc "3.21.0.1"]
                 [ragtime "0.7.2"]]
  :aliases {"migrate" ["run" "-m" "looped-in-server.migrations/migrate"]
            "rollback" ["run" "-m" "looped-in-server.migrations/rollback"]}
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler looped-in-server.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
