#Model Repository service
This project is a service interface for the Model Repository project. It has been developed using the Spring Boot framework.
###API
######Get model by id
[GET] /models/{id}
######Create model
[POST] /models
######Update model
[PUT] /models/{id}
######Delete model
[DELETE] /models/{id}
###How to test
There is a runnable test in ``src/test/java/eu.supersede.dynadapt.modelrepository.service/ModelRepositoryControllerTest.java`` which can be executed as a jUnit test.
###How to run
To run the service in your localhost, execute from command line ```./gradlew bootRun```
###How to deploy
To generate and execute the .jar file, first execute from command line ```./gradlew build```. Then, execute ```java -jar build/libs/gs-rest-service-0.1.0.jar``` and the service should be running in your localhost
