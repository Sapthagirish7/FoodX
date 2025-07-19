# Use official OpenJDK base image
FROM openjdk:17-jdk-slim

# Add a volume for temporary files
VOLUME /tmp

# Copy the built jar file into the container
COPY target/foodx-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
