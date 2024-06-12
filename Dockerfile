FROM openjdk:11.0-jdk-slim-stretch
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT   [ "java","-jar","-Dspring.profiles.active=release","/app.jar" ] 
