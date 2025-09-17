# syntax=docker/dockerfile:1
FROM maven:3.9.11-eclipse-temurin-21-alpine AS build-stage

COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B

COPY ./src ./src
RUN mvn package

FROM eclipse-temurin:21-jre-alpine AS deploy-stage

ENV url=jdbc:sqlite:/data/contacts.db

# act as doc only
EXPOSE 8010
LABEL vendor=wastingnotime.org

# principle of least privilege
RUN addgroup -S nonroot && adduser -S appuser -G nonroot

# just to allow appuser to have access to the data volume
WORKDIR /data
RUN chown appuser .

VOLUME /data

WORKDIR /app
RUN chown appuser .

COPY --from=build-stage ./target/contacts-backend-kotlin-spring-0.0.1-SNAPSHOT.jar app.jar

USER appuser

CMD ["java","-jar","app.jar"]


