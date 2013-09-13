(defproject blog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [prismatic/dommy "0.1.1"]
                 [com.novemberain/monger "1.6.0"]]
  :plugins [[lein-ring "0.8.5"]
            [lein-cljsbuild "0.3.2"]]
  :ring {:handler blog.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}}
  :cljsbuild {
              :builds [{
                        :source-paths ["src-cljs"]
                        :compiler {
                                   :output-to "resources/public/javascripts/main.js"  ; default: target/cljsbuild-main.js
                                   :optimizations :whitespace
                                   :pretty-print true}}]})
