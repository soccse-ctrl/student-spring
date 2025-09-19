# Use OpenJDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy built JAR file into container
COPY target/*.jar app.jar

# Expose the port (Render will map $PORT dynamically)
EXPOSE 8080

# Start the Spring Boot app
CMD ["java", "-Dserver.port=$PORT", "-jar", "app.jar"]
