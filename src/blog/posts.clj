(ns blog.posts
  (:require [monger.core :as mg]
            [monger.collection :as mc])
    (:import [org.bson.types ObjectId]))
(mg/connect!)
(mg/set-db! (mg/get-db "blog"))

(defn create-summary [content]
  (if (> 100 (count content))
    content
    (str (apply str (take 50 content)) "...")))

(defn add-summary [post]
  (conj post {:summary (create-summary (:content post))}))

(defn all []
  (reverse (map add-summary (mc/find-maps "posts"))))

(defn new [title content]
  (mc/insert "posts" {:_id (ObjectId.)
                      :title title
                      :content content}))

(defn find-post [id]
  (mc/find-one-as-map "posts" {:_id (ObjectId. id)}))

(defn destroy-post [id]
  (mc/remove-by-id "posts" (ObjectId. id)))
