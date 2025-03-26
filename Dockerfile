# Use OpenJDK 17 as the base image for building the application
FROM openjdk:17 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use a minimal JDK runtime image for the final container
FROM openjdk:17-jdk-slim AS runtime

# Set working directory for runtime container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
CMD ["java", "-jar", "app.jar"]
