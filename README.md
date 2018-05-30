# http server
java version: JDK 10.0.1
### How to build and run jar file:

1. Download and install java RE 10.0.1 from http://www.oracle.com/technetwork/java/javase/downloads/jre10-downloads-4417026.html
2. Go to the class folder:
```
cd path_to_directory\http_server\scr\com\company
```
3. Build jar file:
```
javac ServerApp.java

jar cfm http_server.jar path_to_directory\http_serverr\scr\META-INF\MANIFEST.MF ServerApp.class
```
4. Run jar file:
```
java -jar path_to_directory\out\artifacts\http_server\http_server.jar
```

### Instructions:

1. Relocate jar file into project's root folder and run it.
2. Open http://localhost:8080 in your browser (port number and html file path can be changed in config.yml file)
