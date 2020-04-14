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

#### Using postgres
`\list` to list the databases

`\c <database>` to choose a database, for example `\c test_db`

`\dt` to list the tables in a database after choosing one  

`\d <table>` to describe a table

## Kafka
[Kafka Tutorial](https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html)

To build kafka and everything necessary, take this straight from the tutorial:
```
git clone https://github.com/confluentinc/examples
cd examples
git checkout 5.4.1-post
cd cp-all-in-one
docker-compose up -d --build${product.refresh.force:false}
```

Once you run that, you can run `docker-compose ps` to make sure that everything is up.
After everything is up, you can navigate to `http://localhost:9021` for the Kafka Control Center.

On the left, select `Topics` and on the right click on `Add Topic`, and name it test.

Once you build and run this app, you should be able to hit the endpoint 
`curl -X POST -F 'message=my_message' http://localhost:8080/kafka/publish` 
and see it produced and consumer in the application logs.