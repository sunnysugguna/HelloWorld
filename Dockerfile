# Start with a Maven and Java image
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY src /app/src
COPY pom.xml /app

# Run Maven clean install to build the application
RUN mvn clean install

# Now, use a Java runtime image to run the application
FROM openjdk:17-slim

# Set the working directory for the runtime container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]