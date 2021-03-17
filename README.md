# Air Company Service
***

## Requirements
#### In order to run this project you need to install Docker
***

### If you don't have a DB
1. Run `docker-compose up --build` it will create and run mysql container with mock data from db/init.sql
2. Run `mvn clean package` to create .jar
3. Run `docker build ./ -t application` and `docker run application` to create application container and run it.

### If you have a DB
1. In `application.properties` change login, password and uri connection
2. Run `mvn clean package` to create .jar
3. Run `docker build ./ -t application` and `docker run application` to create application container and run it.
***

Go to `localhost:8080` and use appropriate url according co available controllers.
***

Tested via Postman.
