FROM openjdk:22
ENV PORT 8080
EXPOSE 8080

mvn clean install
docker build -t hackathon-skill-hunt:latest .
docker tag hackathon-skill-hunt:latest us-central1-docker.pkg.dev/lloyds-hack-grp-05/cloud-run-source-deploy/hackathon-skill-hunt:latest
docker push us-central1-docker.pkg.dev/lloyds-hack-grp-05/cloud-run-source-deploy/hackathon-skill-hunt:latest

COPY target/hackathon-skill-hunt-0.0.1-SNAPSHOT.jar hackathon-skill-hunt-1.0.jar
ENTRYPOINT ["java", "-jar", "/hackathon-skill-hunt-1.0.jar"]
