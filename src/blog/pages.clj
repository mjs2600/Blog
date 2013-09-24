(ns blog.pages
  (:require [hiccup.form :as form])
  (:use [hiccup.page :only (html5 include-js include-css)]))

(defn layout [title & body]
  (html5 [:head
          [:title title]
          (include-css "/css/main.css")]
         [:body
          body
          (include-js "/javascripts/main.js")]))

(defn new-post []
  (layout "New Post"
         [:h1 "New Post"]
         (form/form-to [:post "/posts/new"]
                       (form/label :title "Title")
                       (form/text-field :title)
                       (form/label :content "Body")
                       (form/text-area :content)
                       (form/submit-button "Create New Post"))
         [:a {:href "/"} "Back"]))

(defn show-post [post]
  (layout (str "Blog - " (:title post))
          [:h2 (:title post)]
          [:p (:content post)]
          [:div {:class "controls"}
           [:a {:href "/"} "Back"]
           [:a {:href (str "/posts/"
                           (:_id post)
                           "/destroy")} "Delete"]]))

(defn show-post-summary [post]
  [:div [:h2 (:title post)]
   [:p (:summary post)]
   [:a {:href (str "/posts/"
                   (:_id post))}
    "Read More"]])

(defn show-posts [posts]
  (map show-post-summary posts))

(defn index [posts]
  (layout "Blog"
          [:h1 "Blog"]
          [:a {:href "/posts/new"} "New Post"]
          (show-posts posts)))

(defn test [params]
  (html5 [:body
          [:p "test"]
          [:p (pr-str params)]]))

