FROM openjdk:17-oracle
EXPOSE 8080
ADD target/assignment.jar assignment.jar
ENTRYPOINT ["java", "-jar", "/assignment.jar"]