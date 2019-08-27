FROM openjdk:8-jdk-alpine
COPY build/libs/back-end-0.0.1-SNAPSHOT.jar back-end.jar
CMD ["java", "-Dspring.profiles.active=prod", "-jar", "back-end.jar"]