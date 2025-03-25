# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code into the container
COPY src ./src

# Package the application as a JAR
RUN mvn clean package -DskipTests

# Second stage to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the packaged jar from the previous build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
