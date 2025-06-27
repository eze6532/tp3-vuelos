FROM maven:latest AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package

FROM openjdk:17-jdk-alpine

ARG JAR_FILE=api-vuelos-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/api-vuelos.jar

EXPOSE 8080
ENV JAVA_OPTS=""
CMD exec java $JAVA_OPTS -jar api-vuelos.jar
