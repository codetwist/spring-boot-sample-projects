```bash
docker run --env=POSTGRES_PASSWORD=mYsecret#password \ 
--env=PGDATA=/var/lib/postgresql/data/pgdata \
--volume=<your local directory>:/var/lib/postgresql/data \ 
--volume=/var/lib/postgresql/data -p 5434:5432 -d postgres
