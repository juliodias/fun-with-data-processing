# Builder
FROM maven:3-jdk-8-alpine AS builder

COPY src /usr/app/src/
COPY pom.xml /usr/app/

RUN mvn -f /usr/app/pom.xml clean package -DskipTests

# Release
FROM openjdk:8-jre-alpine

COPY --from=builder /usr/app/target/application-producer.jar /app/
WORKDIR /app

VOLUME /tmp

EXPOSE 8080
ENTRYPOINT java -jar application-producer.jar
