FROM maven:3.9.11-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
ARG BUILD_PROFILE
RUN mvn -f ./pom.xml clean package -DskipTests -P{BUILD_PROFILE}

FROM eclipse-temurin:17.0.16_8-jre-alpine-3.22
WORKDIR /app
ARG JAR_FILE=app/target/*.jar
COPY --from=builder ${JAR_FILE} server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/server.jar"]
