FROM openjdk:17-jdk-slim

WORKDIR /usr/src/app

COPY *.gradle ./
COPY gradle gradle
COPY gradlew .
COPY settings.gradle.kts .
COPY src src

RUN chmod +x ./gradlew

RUN ./gradlew build

COPY build/libs .

CMD ["java", "-jar", "tic_tac_toe-1.0-SNAPSHOT.jar"]