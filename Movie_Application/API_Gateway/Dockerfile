FROM openjdk
WORKDIR usr/src
EXPOSE 9000
ADD ./target/API_Gateway-0.0.1-SNAPSHOT.jar /usr/src/API_Gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","API_Gateway-0.0.1-SNAPSHOT.jar"]