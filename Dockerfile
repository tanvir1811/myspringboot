# Step 1: Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the local code to the container
COPY . .

# Step 4: Build the app using Maven
RUN ./mvnw clean package -DskipTests

# Step 5: Use a smaller image to run the app
FROM openjdk:17-jre-slim

# Step 6: Copy the jar from the build stage to the final container
COPY --from=build /app/target/*.jar /app/app.jar

# Step 7: Expose the port your app will run on
EXPOSE 8080

# Step 8: Define the command to run the app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
