FROM openjdk:latest
COPY ./target/set08103-group24-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "set08103-group24-1.0-SNAPSHOT-jar-with-dependencies.jar"]