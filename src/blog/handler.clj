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
  (GET "/posts/:id/destroy" [id]
       (posts/destroy-post id)
       (pages/index (posts/all)))
  
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
