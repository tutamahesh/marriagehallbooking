FROM maven:3.5-jdk-8-alpine as builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src/
RUN mvn package -DskipTests
#HOST & RUN
FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim
COPY --from=builder /app/target/EurekaServer-0.0.1-SNAPSHOT.jar /eurekaapp.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${PORT}","-jar","/eurekaapp.jar"]
