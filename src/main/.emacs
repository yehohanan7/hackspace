(add-to-list 'load-path "/Users/yehohanan7/dev/tools/emacs/emacsruby/ruby")
(add-to-list 'auto-mode-alist '("\\.rb\\'" . ruby-mode))
(autoload 'ruby-mode "ruby-mode" "Major mode for editing Ruby code" t)

(add-hook 'ruby-mode-hook (lambda () (local-set-key "\r" 'newline-and-indent)))

(require 'inf-ruby)

(require 'ruby-electric)
(add-hook 'ruby-mode-hook (lambda () (ruby-electric-mode t)))


;; recentf stuff
 
(add-to-list 'load-path "/Users/yehohanan7/dev/tools/emacs/recentf-1.23")
 (require 'recentf)
 (recentf-mode 1)
 (setq recentf-max-menu-items 25)
 (global-set-key "\C-x\ \C-r" 'recentf-open-files)


(put 'scroll-left 'disabled nil)



;;temp file


(defvar user-temporary-file-directory
    (concat temporary-file-directory user-login-name "/"))
(make-directory user-temporary-file-directory t)
(setq backup-by-copying t)
(setq backup-directory-alist
            `(("." . ,user-temporary-file-directory)
	              (,tramp-file-name-regexp nil)))
(setq auto-save-list-file-prefix
            (concat user-temporary-file-directory ".auto-saves-"))
(setq auto-save-file-name-transforms
            `((".*" ,user-temporary-file-directory t)))


