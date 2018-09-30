# microservices
Putting different microservices to work together with Spring Cloud Config Server

CHEAT SHEET - MOTOLOLA
======================================================
DOCKER DEPLOYMENT STEPS
======================================================

1. Create Dockerfile in the root of the Java Application.
         FROM openjdk:8
         ADD target/docker-spring-boot-name.jar  docker-spring-boot-name.jar
         EXPOSE 8085
         ENTRYPOINT [“java”, “-jar”, docker-spring-boot-name.jar ]

2. Build the application
    You can rename the default name from the port.xml file before rebuild
     Rebuild for each update.

3.Build Image
  docker build -f Dockerfile -t docker-spring-boot-name  . (not the dot at the end)
  docker images (shows list of built images on the system)
  docker run -p 8085:8085 docker-spring-boot-name

SPRING CLOUD MICROSERVICES CONFIGURATION
==============================

1.Create a GIT Repository
2.Create a Spring Cloud SERVER and SET the port eg.
```
server.port=8888
```
3. Set the application name eg,
```
spring.application.name=spring-cloud-config-server
```
4.Connect the SERVER to the git Repository via the Application properties. eg
```
spring.cloud.config.server.git.uri=file:///motolola/git/spring-micro-services/03.microservices/git-localconfig-repo

```
5.Enable Spring Cloud Config Server from the Application class eg. @EnableConfigServer

 ====== TO CONNECT a CLIENT=====

1. CREATE a SPRING CLOUD Client
2. Rename the application.properties to bootstrap.properties 
3. Set the application name (this MUST = {name}-profile.properties in the GIT Repo), eg
```
spring.application.name=limits-service
```
4. Give the URI of the CONFIG SERVER eg
```
spring.cloud.config.uri=http://localhost:8888
```
5. Give the active profile eg.
```
spring.profiles.active=prod
```
