# Use a base image with Java 17
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /opt

# Copy the JAR file from your local machine to the container
COPY target/*.jar /opt/app.jar

# Expose the port your Spring Boot app is running on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]