# Use Maven with Java 21
FROM maven:3.8.4-openjdk-21 AS build

WORKDIR /app

# Copy the Maven project files and build dependencies offline
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use OpenJDK 21 in the final runtime image
FROM openjdk:21-jdk-slim AS stage-1

WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
