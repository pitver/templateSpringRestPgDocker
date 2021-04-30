FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
VOLUME D:/gitTest
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]