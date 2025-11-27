FROM openjdk:26-ea-oraclelinux8

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/locate.jar

ENTRYPOINT ["java", "-jar", "target/locate.jar"]