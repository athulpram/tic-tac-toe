(ns reagent-app.core
    (:require
      [reagent.core :as r]))

(def table-data (r/atom {:one nil, :two nil, :three nil, :four nil, :five nil, :six nil, :seven nil, :eight nil, :nine nil}))
(def players (r/atom ["O", "X"]))
(def current-player (r/atom 0))

(defn change-turn []
  (swap! current-player (fn [n] (- (- n 1)))))

(defn mark [event]
  (do
    (swap! table-data assoc-in [(keyword event.target.id)] (@players @current-player))
    (change-turn)))

(defn tic-tac-toe-table [table-data]
  [:div [:table
         [:tr
          [:td [:button {:id :one :style {:width 100 :height 100 :font-size 50} :on-click mark} (:one @table-data)]]
          [:td [:button {:id :two :style {:width 100 :height 100 :font-size 50} :on-click mark} (:two @table-data)]]
          [:td [:button {:id :three :style {:width 100 :height 100 :font-size 50} :on-click mark} (:three @table-data)]]
          ]
         [:tr
          [:td [:button {:id :four :style {:width 100 :height 100 :font-size 50} :on-click mark} (:four @table-data)]]
          [:td [:button {:id :five :style {:width 100 :height 100 :font-size 50} :on-click mark} (:five @table-data)]]
          [:td [:button {:id :six :style {:width 100 :height 100 :font-size 50} :on-click mark} (:six @table-data)]]]
         [:tr
          [:td [:button {:id :seven :style {:width 100 :height 100 :font-size 50} :on-click mark} (:seven @table-data)]]
          [:td [:button {:id :eight :style {:width 100 :height 100 :font-size 50} :on-click mark} (:eight @table-data)]]
          [:td [:button {:id :nine :style {:width 100 :height 100 :font-size 50} :on-click mark} (:nine @table-data)]]
          ]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [tic-tac-toe-table table-data] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
