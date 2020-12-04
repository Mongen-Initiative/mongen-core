# Mongen - Core Service

This is a Spring Boot service to manage data for Mongen clients

#### Create a new database for this service with Docker

```
docker run --name mongen_core_db -e POSTGRES_PASSWORD=123123 -e POSTGRES_USER=mongen -e POSTGRES_DB=mongen_db -p 5432:5432 -d postgres:12
docker exec -it mongen_core_db psql -h localhost -p 5432 -U mongen mongen_db
```
