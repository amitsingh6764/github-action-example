FROM eclipse-temurin:17-jdk-jammy
COPY target/github-action-example.jar github-action-example.jar
EXPOSE 9908
ENTRYPOINT ["java", "-jar", "/github-action-example.jar"]