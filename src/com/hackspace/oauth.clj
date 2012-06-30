(ns com.hackspace.oauth)

(import '(javax.crypto.spec SecretKeySpec))
(import '(javax.crypto Mac))
(import '(org.apache.commons.codec.binary Base64))

(import '(oauth.signpost.commonshttp CommonsHttpOAuthConsumer ))
(import '(oauth.signpost.basic DefaultOAuthConsumer))
(import '(org.apache.http.client.methods HttpGet HttpPost))
(import '(java.net HttpURLConnection URL))
(import '(org.apache.http HttpRequest))
(import '(org.apache.http.impl.client DefaultHttpClient BasicResponseHandler))

(import '(javax.xml.crypto.dsig SignatureMethod))

(def consumerkey "ny5yv5yow0yfqwr")
(def consumersecret "q5oemkk7d2muvxp")


;;(def SHA "HmacSHA1")
;;(def ENCODE "UTF-8")



;;(defn generate-signature [url method params]
 ;; (let [mac (Mac/getInstance SHA) base (str method "&" url "&" params) key (SecretKeySpec. (.getBytes (str consumersecret "&") ENCODE) SHA)]
 ;;   (.init mac key)
 ;;   (String. (.encode (new Base64) (.doFinal mac (.getBytes base ENCODE))) ENCODE)
 ;;   )
 ;; )

(defn http-get [url token secret params]
  (let [consumer (CommonsHttpOAuthConsumer. consumerkey consumersecret) http-client (new DefaultHttpClient) get-request (new HttpGet url)]
    (. consumer setTokenWithSecret token secret)
    (. consumer sign get-request)
    (. http-client execute get-request (new BasicResponseHandler))

    )
  )


(println (http-get "https://api.dropbox.com/1/account/info" "dvidfhemn0w9zt8" "2y4r0jubhm9hils"  {}))