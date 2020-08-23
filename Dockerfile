<<<<<<< HEAD
FROM openjdk:11-jdk-slim
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar /opt/app.jar
WORKDIR /opt
=======
FROM openjdk:11-jdk-slim
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar /opt/app.jar
WORKDIR /opt
>>>>>>> 5e663ff6dbdc33ffd427578215b055b2799e4b4f
CMD ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]