# abandoned WIP application
1. DB settings in application.properties adjusted for docker-compose localhost container
2. First run `docker-compose up --build` then do `mvn clean package` and finally `docker build ./ -t application` with `docker run application`