# Mongen - Core Service

This is a Spring Boot service to manage data for Mongen clients

#### Create a new database for this service with Docker

```
docker run --name mongen_core_db -e POSTGRES_PASSWORD=123123 -e POSTGRES_USER=mongen -e POSTGRES_DB=mongen_db -p 5432:5432 -d postgres:12
docker exec -it mongen_core_db psql -h localhost -p 5432 -U mongen mongen_db
```


### Local development
#### Start the database

Have Docker running on your machine, execute 
```
docker start mongen_core_db
```

#### Start the core

Go to your Java IDE and run the file located at /src/java/org.mongen.core/MongenCoreService -> https://github.com/Mongen-Initiative/mongen-core/blob/main/src/main/java/org/mongen/core/MongenCoreService.java . This will start the application.

Swagger URL http://localhost:8080/swagger-ui.html


#### Start the frontend

In the frontend folder, run
```
npm run dev
```
