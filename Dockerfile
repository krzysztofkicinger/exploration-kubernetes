FROM openjdk:11-jdk-slim
COPY ./target/exploration-kubernetes-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]