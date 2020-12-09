# Gradle Webapp React Sample

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

NPM Downloads
```
https://nodejs.org/en/download/
```

```
npx create-react-app frontend
```

```
cd frontend
npm start
```

```
npm install
```

```
npm run-script build
```

```
npm run eject
```

frontend/config/path.js
- appBuild: resolveApp('build/static') 추가
- frontend/build 모든 파일 삭제

build.gradle 다음 내용 추가
```text
def webappDir = "$projectDir/src/main/frontend"

sourceSets {
    main {
        resources {
            srcDirs = ["$webappDir/build", "$projectDir/src/main/resources"]
        }
    }
}

processResources {
    dependsOn "buildReact"
}

task buildReact(type: Exec) {
    dependsOn "installReact"
    workingDir "$webappDir"
    inputs.dir "$webappDir"
    group = BasePlugin.BUILD_GROUP
    if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {
        commandLine "npm.cmd", "run-script", "build"
    } else {
        commandLine "npm", "run-script", "build"
    }
}

task installReact(type: Exec) {
    workingDir "$webappDir"
    inputs.dir "$webappDir"
    group = BasePlugin.BUILD_GROUP
    if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {
        commandLine "npm.cmd", "audit", "fix"
        commandLine 'npm.cmd', 'install'
    } else {
        commandLine "npm", "audit", "fix"
        commandLine 'npm', 'install'
    }
}
```

gradle build

```text
localhost:8080 접속
```

