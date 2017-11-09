(defproject labelmaker-frontend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.9.0-RC1"]
                 [org.clojure/clojurescript "1.9.946"]
                 [reagent "0.7.0"]
                 [reagent-utils "0.2.1"]
                 [re-com "2.1.0"]
                 [cljs-ajax "0.7.3"]
                 [jarohen/chord "0.8.1"]
                 [org.clojure/core.async "0.3.443"]
                 [devcards "0.2.4"]
                 [org.clojure/test.check "0.9.0"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel "0.5.14"]]

  :min-lein-version "2.5.0"

  :clean-targets ^{:protect false}
  [:target-path
   [:cljsbuild :builds :app :compiler :output-dir]
   [:cljsbuild :builds :app :compiler :output-to]]

  :resource-paths ["public"]

  :figwheel {:http-server-root "."
             :nrepl-port 7002
             :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
             :css-dirs ["public/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src" "env/dev/cljs"]
                        :compiler
                        {:main "labelmaker-frontend.dev"
                         :output-to "public/js/app.js"
                         :output-dir "public/js/out"
                         :asset-path   "js/out"
                         :source-map true
                         :optimizations :none
                         :pretty-print  true}
                        :figwheel
                        {:on-jsload "labelmaker-frontend.core/mount-root"
                         :open-urls ["http://localhost:3449/index.html"]}}
                       :devcards
                       {:source-paths ["src" "env/dev/cljs" "test"]
                        :figwheel
                        {:devcards true}
                        :compiler
                        { :main       "labelmaker-frontend.dev"
                         :asset-path "js/devcards_out"
                         :output-to  "public/js/devcards.js"
                         :output-dir "public/js/devcards_out"
                         :optimizations :none
                         :source-map-timestamp true }}
                       :release
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler
                        {:output-to "public/js/app.js"
                         :output-dir "public/js/release"
                         :asset-path   "js/out"
                         :optimizations :advanced
                         :pretty-print false}}}}

  :aliases {"package" ["do" "clean" ["cljsbuild" "once" "release"]]}

  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.7"]
                                  [figwheel-sidecar "0.5.14"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [com.cemerick/piggieback "0.2.2"]]}})
