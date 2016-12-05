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