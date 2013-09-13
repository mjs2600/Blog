(ns blog.main
  (:use-macros
   [dommy.macros :only [sel sel1]])
  (:require
   [dommy.utils :as utils]
   [dommy.core :as dommy]))

(defn start []
  (dommy/replace! (sel1 :div) [:div "Hello"]))

(set! (.-onload js/window) start)
