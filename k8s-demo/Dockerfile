# Stage 1: Build the application
FROM maven:3.9.1-eclipse-temurin-17 AS build

# Set the working directory
WORKDIR /app

# Copy pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-focal

# Set the working directory
WORKDIR /app

# Copy the packaged jar from the build stage
COPY --from=build /app/target/k8s-demo.jar app.jar

# Expose the port the application runs on
EXPOSE 9099

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]