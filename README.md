Project : StudentManagementApp
-----------------------------------------------
- Tech Stack
  - Spring Boot.
  - H2 - in memory Database.
  - Spring Data JPA - uses Hibernate as JPA implementation.
  - Swagger - used for Documenting Rest API’s.
  - Logback - used for logging.
  - Spring-Data-Redis for Caching.
- It is RESTful Web Service.
- Implemented CRUD operations.
- Implemented Caching using Redis.
- Github link : https://github.com/srikanthmergu04/StudentManagementApp_RESTfulWebService_SpringBoot.git

Cache Implementation using Spring-Data-Redis
 ---------------------------------------------------
 - #### Installing Redis on windows 10
    - Downlad link : https://github.com/microsoftarchive/redis/releases
        - you can download either .zip or .msi , and extract it
    
  - #### Starting Redis Server Locally
    - open CMD and point to the redis installation directory and execute the below command.
            
            `redis-server`
    - you can see "**server started**" message on console.
  - #### Cache Configuration in application.properties file
    - `spring.cache.type=redis`
    - `spring.redis.host=localhost`
    -  `spring.redis.port=6379`
    
    - you can see `application.properties` file for remaining configurations.
        
     
         
  