FROM openjdk:11
ADD target/air-company.jar air-company.jar
ENTRYPOINT ["java", "-Dserver.port=8081", "-jar","/air-company.jar"]
