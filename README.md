# Microservices
Putting different microservices to work together with Spring Cloud Config Server

CHEAT SHEET - MOTOLOLA
======================================================

SPRING CLOUD MICROSERVICES CONFIGURATION
==============================

1.Create a GIT Repository, Note the file or remote location. <br/>
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
