(ns labelmaker-frontend.prod
  (:require
    [labelmaker-frontend.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
