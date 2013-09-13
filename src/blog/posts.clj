(ns blog.posts
  (:require [monger.core :as mg]
            [monger.collection :as mc])
    (:import [org.bson.types ObjectId]))
(mg/connect!)
(mg/set-db! (mg/get-db "blog"))

(defn all []
  (reverse (mc/find-maps "posts")))

(defn new [title content]
  (mc/insert "posts" {:_id (ObjectId.)
                      :title title
                      :content content}))

(defn find-post [id]
  (mc/find-one-as-map "posts" {:_id (ObjectId. id)}))
