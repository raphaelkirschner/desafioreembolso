FROM openjdk:20
WORKDIR /app
COPY target/reembolso-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java","-jar","app.jar"]