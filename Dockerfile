FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/iPAS-*.jar app.jar
VOLUME /data/iPAS
ENTRYPOINT ["java", "-jar", "app.jar"]
