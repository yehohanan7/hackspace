(require 'package)
(add-to-list 'package-archives
	                  '("marmalade" . "http://marmalade-repo.org/packages/") t)
(package-initialize)

;;recentf stuff
(require 'recentf) 
 (recentf-mode 1)
 (setq recentf-max-menu-items 25)
(global-set-key "\C-x\ \C-r" 'recentf-open-files)

;;clojure
(add-to-list 'load-path "~/.emacs.d/clojure/clojure-mode")
(require 'clojure-mode)


;; slime
(add-to-list 'load-path "~/.emacs.d/clojure/slime")
(require 'slime)
(slime-auto)

;;swank
(add-to-list 'load-path "~/.emacs.d/clojure/swank-clojure")
(setq swank-clojure-library "/opt/local/bin/clj")
(require 'swank-clojure-autoload)

