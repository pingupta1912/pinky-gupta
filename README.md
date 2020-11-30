

This project depicts the Spring Boot Example with Spring Data MongoDB and REST Example.

Have inserted two dummy records in database using MongoDBConfig

Please follow below commands to run dockerized image -

docker image build -t products .
docker run -d -p 27017:27017 --name --net backend mongo mongo:latest
docker run --rm -p 8095:8095 --name products  --net backend --link mongo:mongo products

Postman Requests -
GET Request - http://localhost:8095/products/1
PUT Request - http://localhost:8095/products/1
Request body - {
                   "id": "1",
                   "name": "Peter",
                   "price": {
                       "cost": 4.5,
                       "currency": "$"
                   }
               }
