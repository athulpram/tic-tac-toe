(ns reagent-app.core
    (:require
      [reagent.core :as r]
      ))

(def table-data (r/atom {:one nil, :two nil, :three nil, :four nil, :five nil, :six nil, :seven nil, :eight nil, :nine nil}))
(def winning-positions (r/atom #{
                                 #{:one :two :three}
                                 #{:four :five :six}
                                 #{:seven :eight :nine}
                                 #{:one :four :seven}
                                 #{:two :five :eight}
                                 #{:three :six :nine}
                                 #{:one :five :nine}
                                 #{:three :five :seven}
                                 }))
(def players (r/atom ["O", "X"]))
(def current-player (r/atom 0))
(def button-style {:width 100 :height 100 :font-size 50})

(defn change-turn []
  (swap! current-player (fn [n] (- (- n 1)))))

(defn has-won [player]
  (do
    (if-not (empty? (filter (fn [n] (clojure.set/subset? n (set (filter (comp #{player} @table-data) (keys @table-data)))))
          @winning-positions))
          (js/alert (str "Hurray \"" player "\" Won the game"))
      )))

(defn mark [event]
  (do
    (swap! table-data assoc-in [(keyword event.target.id)] (@players @current-player))
    (has-won (@players @current-player))
    (change-turn)
    ))

(defn tic-tac-toe-table [table-data]
  [:div [:table
         [:tr
          [:td [:button {:id :one :style button-style :on-click mark} (:one @table-data)]]
          [:td [:button {:id :two :style button-style :on-click mark} (:two @table-data)]]
          [:td [:button {:id :three :style button-style :on-click mark} (:three @table-data)]]
          ]
         [:tr
          [:td [:button {:id :four :style button-style :on-click mark} (:four @table-data)]]
          [:td [:button {:id :five :style button-style :on-click mark} (:five @table-data)]]
          [:td [:button {:id :six :style button-style :on-click mark} (:six @table-data)]]]
         [:tr
          [:td [:button {:id :seven :style button-style :on-click mark} (:seven @table-data)]]
          [:td [:button {:id :eight :style button-style :on-click mark} (:eight @table-data)]]
          [:td [:button {:id :nine :style button-style :on-click mark} (:nine @table-data)]]
          ]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [tic-tac-toe-table table-data] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
