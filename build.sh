rm com.hackspace-1.0.0-SNAPSHOT.jar 
rm com.hackspace-1.0.0-SNAPSHOT-standalone.jar 
rm hs.db.user
lein clean
lein uberjar


./hs --init

