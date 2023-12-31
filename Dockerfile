# Use a base image with Java and Maven (replace the version with your preferred one)
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml file
COPY pom.xml .

# Download the Maven dependencies (this step can be cached by Docker)
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application as a war file
RUN mvn package -DskipTests

# Use a base image for the application runtime (replace the version with your preferred one)
FROM tomcat:9-jdk17-openjdk-slim

# Remove the default ROOT webapp
RUN rm -rf /usr/local/tomcat/webapps/BadmintonClub

# Set the working directory
WORKDIR /usr/local/tomcat/webapps

# Copy the war file from the build stage to the Tomcat webapps directory with ROOT as context path
COPY --from=build /app/target/*.war ./BadmintonClub.war

# Expose port 8080 (default port for Spring Boot)
EXPOSE 8888

# Start Tomcat when the Docker container starts
CMD ["catalina.sh", "run","BadmintonClub.war"]