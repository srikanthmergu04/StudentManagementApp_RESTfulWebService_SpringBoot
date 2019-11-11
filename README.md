Project : StudentManagementApp
-----------------------------------------------
- Tech Stack
  - Spring Boot.
  - H2 - in memory Database.
  - Spring Data JPA - uses Hibernate as JPA implementation.
  - Swagger - used for Documenting Rest API’s.
  - Logback - used for logging.
  - Spring-Data-Redis for Caching.
  - JasperReports - used ireport tool for Designing Report.
- It is RESTful Web Service.
- Implemented CRUD operations.
- Implemented Caching using Redis.
- Github link : https://github.com/srikanthmergu04/StudentManagementApp_RESTfulWebService_SpringBoot.git

Cache Implementation using Spring-Data-Redis
 ---------------------------------------------------
 - #### Installing Redis on windows 10
    - Download link : https://github.com/microsoftarchive/redis/releases
        - you can download either .zip or .msi.
        - extract it after downloading.
    
  - #### Starting Redis Server Locally
    - open CMD and point to the redis installation directory and execute the below command.
            
            `redis-server`
    - you can see "**server started**" message on the console.
  - #### Cache Configuration in application.properties file
    - `spring.cache.type=redis`
    - `spring.redis.host=localhost`
    -  `spring.redis.port=6379`
    
    - you can also see other properties in `application.properties` file.
        
Implementing Jasper Reports using ireport tool [for Designing]
--------------------------------------------------
- Download : https://sourceforge.net/projects/ireport/files/iReport/iReport-5.6.0/iReport-5.6.0.zip/download   
- after downloading extract it and open `ireport.conf` and
  `jdkhome="C:\Program Files\Java\jre7"`  
 - open **ireport tool**   by going to bin folder of installation directory.
 - create a report as you like then get .jrxml file and use it in your application/project.
 - open `ReportService.java` file under Service package for implementation.    
  
