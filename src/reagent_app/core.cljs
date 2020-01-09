(ns reagent-app.core
    (:require
      [reagent.core :as r]))
    ;(:require-macros
    ;  [cljss.core :refer [defstyles]])

;; -------------------------
;; Views
;
;(defstyles cell-style []
;           {
;            :width 10
;            :height 10
;            })

(defn table [table-data]
  [:div [:table
         [:tr
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:one table-data)]]
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:two table-data)]]
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:three table-data)]]
          ]
         [:tr
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:four table-data)]]
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:five table-data)]]
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:six table-data)]]]
         [:tr
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:seven table-data)]]
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:eight table-data)]]
          [:td [:button {:style {:width 100 :height 100 :font-size 50}} (:nine table-data)]]
          ]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [table {:one 0, :two 0, :three 1, :four 1, :five 1, :six 0, :seven 0, :eight 1, :nine 1}] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
