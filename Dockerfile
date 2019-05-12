FROM java:8-jdk-alpine

COPY ./target/rest-service-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch rest-service-1.0-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","rest-service-1.0-SNAPSHOT.jar"]