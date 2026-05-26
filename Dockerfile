FROM maven:3.9.15-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY src /app/src
COPY pom.xml .

RUN mvn clean package -DskipTests && \
    mvn dependency:copy-dependencies -DincludeScope=runtime -DoutputDirectory=target/libs

FROM eclipse-temurin:21-jre-ubi9-minimal

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
COPY sql /app/sql

ENTRYPOINT ["java", "-jar", "app.jar"]