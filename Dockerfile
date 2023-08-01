FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17-ea-18-jdk-slim
ARG JAR_FILE=target/BadmintonClub-0.0.1-SNAPSHOT.war
COPY --from=build ${JAR_FILE} app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.war"]