#Model Repository Manager
###Installation
- Clone the repository
- Fill in your database credentials (dbhost, dbuser, dbpassword) in the config.properties file:``` src/main/java/eu/supersede/dynadapt/modelrepository/manager/database/config.properties```
- Deploy the database using ```deployment/model_repository_deployment.sql```
- Install the library into your local maven repository:
```bash
mvn clean install
```
