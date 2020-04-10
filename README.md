# hv-demo

## Setting up Postgres DB
Create and run the postgres container
```
docker run -d --name my_postgres -e POSTGRES_PASSWORD=password -v my_dbdata:/var/lib/postgresql/data -p 5432:5432 postgres
```

To create a database in postgres called test_db
```
docker exec my_postgres psql -U postgres -c"CREATE DATABASE test_db" postgres
```

To get a terminal to the database
```
docker exec -it my_postgres psql -U postgres
```

## Using postgres
`\list` to list the databases

`\c <database>` to choose a database, for example `\c test_db`

`\dt` to list the tables in a database after choosing one  

`\d <table>` to describe a table