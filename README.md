# Kafka Spring boot 

## Requirements 

Java 17

MySQL

## Configurations

Please added mysql configurations into application.yml

url ,username, password

## Start Kafka Server
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties

## Start Spring boot application

mvn spring-boot:run

## Postman requests

[Postman Collection ](KafkaAssement.postman_collection.json) 

![Screen shot ](ss.png)


