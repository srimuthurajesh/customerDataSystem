# Customer master Data system
### About project:
This app will consumes customer data from kafka event and do the insertion, then it has REST apis to retrive the customer details by firstname and lastname

### Prerequites softwares
Java 8
Docker


### Steps to Start the project
1. Run the docker-compose.yml file by using the command **Docker-compose up -d**
2. Hence mysql avialable in localhost:3306, adminer in lcoalhost:8083, 
3. kafka in kafka:29092
    1. Run topic creation command ``` kafka-topics --create --zookeeper zookeeper:32188 --partitions 1 --replication-factor=1 --topic customer-new ```
    2. Run producer command to add data ``` kafka-console-producer --topic customer-new --broker-list kafka:29092```
4. Run ```mvn spring-boot:run``` to start the application
5. Hit Url: 
    1. http://localhost:8082/customerdatasystem/api/v1.0.0/customers/getByFirstName/Alex
    2. http://localhost:8082/customerdatasystem/api/v1.0.0/customers/getByLastName/mac  

Refer swagger

