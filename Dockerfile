FROM openjdk:26-ea-oraclelinux8

WORKDIR /app

COPY ./target/*.jar /app/locate.jar


ENTRYPOINT ["java", "-jar", "/app/locate.jar"]