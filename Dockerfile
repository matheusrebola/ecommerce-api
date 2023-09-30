# START build
FROM maven:3.8.3-jdk-11-slim AS build 

RUN mkdir /project

COPY . /project

WORKDIR /project

RUN mvn clean package
# END build

# START run
FROM adoptopenjdk/openjdk11:jre-11.0.15_10-alpine

RUN mkdir /app

COPY --from=build /project/target/ecommerce-0.0.1-SNAPSHOT.war /app/ecommerce-0.0.1-SNAPSHOT.war

ENV PROFILE=dev
# ENV profile=stg 
# ENV profile=prd 

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "ecommerce-0.0.1-SNAPSHOT.war"]
# END run
