# Stage 1: Build Spring Boot App
FROM maven:3.9.6-eclipse-temurin-21 AS backend
WORKDIR /app
COPY backend/pom.xml ./
COPY backend/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run Spring Boot App
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=backend /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]