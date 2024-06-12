FROM openjdk:17-jdk-slim
COPY target/scala-2.13/akka-http-quickstart-scala-assembly-0.1.0-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]