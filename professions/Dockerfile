FROM maven:3.6.1-jdk-11
ARG ARG_DOCKER_TAG=no_tag
EXPOSE 5005
EXPOSE 8008

COPY . /professions
WORKDIR /professions

RUN mvn clean install package -DskipTests

ENTRYPOINT ["java", "-jar", "target/professions-0.0.1-SNAPSHOT.jar"]
