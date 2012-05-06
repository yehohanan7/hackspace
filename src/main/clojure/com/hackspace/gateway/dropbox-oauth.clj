(ns com.hackspace.gateway.dropbox-oauth)
(import '(com.dropbox.client2.session AppKeyPair Session WebAuthSession RequestTokenPair Session$AccessType))
(import '(com.dropbox.client2 DropboxAPI))

(def consumerkey "")
(def consumersecret "")

(defn fetch-authorization-url [consumer-key consumer-secret]
  {:pre [(= false (and (nil? consumer-key) (nil? consumer-secret)))]}

  (let
    [api (DropboxAPI. (WebAuthSession. (AppKeyPair. consumer-key consumer-secret ) (Session$AccessType/DROPBOX)))]
    (.url (.. api (getSession) (getAuthInfo)))
    )
  )

(println "Authorization url: " (fetch-authorization-url consumerkey consumersecret))