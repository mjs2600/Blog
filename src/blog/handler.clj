(ns blog.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [blog.pages :as pages]
            [blog.posts :as posts]))

(defroutes app-routes
  (GET "/" [] (pages/index (posts/all)))
  (GET "/posts/new" [] (pages/new-post))
  (POST "/posts/new" [title content]
        (posts/new title content)
        (pages/index (posts/all)))
  (GET "/posts/:id" [id] (pages/show-post (posts/find-post id)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
