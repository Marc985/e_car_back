FROM maven:3.8.5-openjdk-17 AS build
COPY .. .
RUN mvn clean package -Dskiptests

FROM openjdk:21-jdk
COPY --from=build /target/backend-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","backend.jar"]

