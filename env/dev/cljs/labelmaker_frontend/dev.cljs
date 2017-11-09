(ns ^:figwheel-no-load labelmaker-frontend.dev
  (:require
    [labelmaker-frontend.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
