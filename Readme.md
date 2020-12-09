### Gradle Webapp Sample

https://spring.io/guides/gs/spring-boot-docker/

Gradle Build
```
gradlew clean build -Pprofile=dev -x test && java -jar build/libs/gradle-webapp-1.0-SNAPSHOT.jar
```

Docker Build/Run
```
$ docker build --build-arg JAR_FILE=build/libs/*.jar -t cheol/gradle-webapp-docker:1.0-SNAPSHOT
$ docker run -p 8080:8080 cheol/gradle-webapp-docker
```