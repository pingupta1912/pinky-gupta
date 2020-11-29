# Spring Boot Using Spring Data MongoDB Example

This project depicts the Spring Boot Example with Spring Data MongoDB and REST Example.

Have inserted two dummy records in database using MongoDBConfig

Please follow below commands to run dockerized image -

docker image build -t products .
docker run -d -p 27017:27017 --name --net backend mongo mongo:latest
docker run --rm -p 8095:8095 --name products  --net backend --link mongo:mongo products


