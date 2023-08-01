# Use a base image that supports Java, such as AdoptOpenJDK
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory to /app
WORKDIR /app

# Copy the packaged WAR file into the container
COPY target/BadmintonClub-0.0.1-SNAPSHOT.war /app/app.war

# Make port 8080 available to the world outside the container
EXPOSE 8080

# Run the application with Java
CMD ["java", "-jar", "app.war"]/app.war"]