(ns blog.pages
  (:require [hiccup.form :as form])
  (:use [hiccup.page :only (html5 include-js)]))

(defn new-post []
  (html5 [:body
          [:h1 "Blog"]
          [:a {:href "/"} "Back"]
          (form/form-to [:post "/posts/new"]
                        (form/text-field :title)
                        (form/text-area :content)
                        (form/submit-button "Create New Post"))
          (include-js "/javascripts/main.js")]))

(defn show-post [post]
  (html5 [:h2 (:title post)]
         [:p (:content post)]
         [:a {:href (str "/posts/"
                         (:_id post))}
          "Read More"]))

(defn show-posts [posts]
  (map show-post posts))

(defn index [posts]
  (html5 [:body
          [:h1 "Blog"]
          [:a {:href "/posts/new"} "New Post"]
          [:div "Hi"]
          (show-posts posts)
          (include-js "/javascripts/main.js")]))

(defn test [params]
  (html5 [:body
          [:p "test"]
          [:p (pr-str params)]]))
