FROM openjdk:11

COPY target/ptt-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]