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


(defn http-get [url token secret params]
  (let [consumer (CommonsHttpOAuthConsumer. consumerkey consumersecret) http-client (new DefaultHttpClient) get-request (new HttpGet url)]
    (. consumer setTokenWithSecret token secret)
    (. consumer sign get-request)
    (. http-client execute get-request (new BasicResponseHandler))
    )
  )