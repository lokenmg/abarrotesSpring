FROM maven:3.6.3-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn package

FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build target/Abarrotes-0.0.1-SNAPSHOT.jar /app/Abarrotes-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/myapp.jar"]

