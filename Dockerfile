### I AM A M1 USER. I HAVE TO USE PLATFORM KEYWORD ###
FROM --platform=linux/amd64 eclipse-temurin:17-jdk-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]