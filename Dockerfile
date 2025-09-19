# Use OpenJDK
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

# Pass Render's $PORT to Spring Boot
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]