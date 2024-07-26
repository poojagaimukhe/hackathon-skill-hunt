FROM openjdk:22
#EXPOSE 8080
COPY target/hackathon-skill-hunt-0.0.1-SNAPSHOT.jar hackathon-skill-hunt-1.0.jar
ENTRYPOINT ["java", "-jar", "/hackathon-skill-hunt-1.0.jar"]