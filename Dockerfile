FROM eclipse-temurin:17-jdk-jammy
COPY target/github-action.jar github-action.jar
EXPOSE 9908
ENTRYPOINT ["java", "-jar", "/github-action.jar"]