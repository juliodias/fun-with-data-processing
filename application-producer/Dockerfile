# Build
FROM maven:3-jdk-8-alpine AS builder

COPY pom.xml /usr/app/pom.xml
RUN mvn -f /usr/app/pom.xml dependency:go-offline -B

COPY src /usr/app/src/

RUN mvn -f /usr/app/ package -DskipTests

# Release
FROM openjdk:8-jre-alpine

COPY --from=builder /usr/app/target/application-producer.jar /app/
WORKDIR /app

EXPOSE 8080
ENTRYPOINT java -jar application-producer.jar
