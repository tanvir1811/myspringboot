# Use Maven with OpenJDK 17 for building the application
FROM maven:3.8.4-openjdk-17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./

# Download project dependencies
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Build the application JAR file
RUN mvn package -DskipTests

# Use a lightweight OpenJDK runtime image for running the application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR file from the builder container
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 for the application
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
