## Used Technology:
```bash
* Java 17
* Spring Boot 3.2
* Kafka and Redis
* Docker
* H2 database
```

## How to run?
### Java application
```bash
* Clone this git repository to local
* Import this project file as maven project to a IDE like Eclipse or Intellij Idea.
* Run this project as "Java Application"
```

### Start kafka
```bash
*Run below command in 3 different termial and the path should be inside kafka folder where all kafka files are present
1. bin/windows/zookeeper-server-start.bat config/zookeeper.properties
2. bin/windows/kafka-server-start.bat config/server.properties
3. Run this project as "Java Application"
```

### Start redis-server
```bash
* Double clicking on redis server inside redis folder.(The server is available in online)
```

### Necessary commands for docker
```bash
1. docker run image_name (This command is used to run docker image)
```

### CURLs for CRUD operation testing
```bash
* Open Postman
* Import below mentioned curl into postman. then hit the URL from postman.
1. curl --location 'http://localhost:8080/api/user'
2. curl --location 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data '    {
        "firstName": "Ahmed",
        "lastName": "User",
        "age": 28
    }'
3. curl --location --request PUT 'http://localhost:8080/api/user/1' \
--header 'Content-Type: application/json' \
--data '{
    "id": 1,
    "firstName": "Asif",
    "lastName": "Ahmed",
    "age": 30
}'
4. curl --location 'http://localhost:8080/api/user/1'
5. curl --location --request DELETE 'http://localhost:8080/api/user/1'
```
