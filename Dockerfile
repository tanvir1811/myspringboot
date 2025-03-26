# Use Maven with OpenJDK 21 to build the application
FROM maven:3.8.4-openjdk-21 AS build
WORKDIR /app

# Copy pom.xml and install dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn package -DskipTests

# Use a minimal JDK runtime image for the final container
FROM openjdk:21-jdk-slim AS stage-1
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
