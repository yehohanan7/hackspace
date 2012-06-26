mvn install:install-file -Dfile=dropbox-java-sdk-1.3.1.jar -DgroupId=com.dropbox -DartifactId=dropbox-java-sdk -Dversion=1.3.1 -Dpackaging=jar
mvn install:install-file -Dfile=json_simple-1.1.jar -DgroupId=com.dropbox -DartifactId=json_simple -Dversion=1.1 -Dpackaging=jar

lein clean
lein uberjar