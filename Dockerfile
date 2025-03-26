# Step 1: Use the JDK 17 base image to build the application with Maven
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file (pom.xml) into the container
COPY pom.xml .

# Download the dependencies to the container (not building the app yet)
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY src /app/src

# Step 2: Build the application using Maven
RUN mvn clean package -DskipTests

# Step 3: Use a minimal JDK 17 runtime image for the final container
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar /app/website.jar

# Expose the port the application will run on (default Spring Boot port)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/website.jar"]
