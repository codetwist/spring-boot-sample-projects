
How to start Postgres container in Docker
```bash
docker run --env=POSTGRES_PASSWORD=mYsecret#password \ 
--env=PGDATA=/var/lib/postgresql/data/pgdata \
--volume=<your local directory>:/var/lib/postgresql/data \ 
--volume=/var/lib/postgresql/data -p 5434:5432 -d postgres
```

The POSTGRES_PASSWORD value should match the _spring.datasource.password_ in
[application.properties](src/main/resources/application.properties).