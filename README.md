# Sample Java REST API with Spring MVC framework

## Description
This code is a sample of Java REST API using Spring MVC framework and other technologies, like:

* [Spring Initializr](https://start.spring.io/) - Create Spring Boot Java projects;
* Startup with Spring Boot (@SpringBootApplication);
* REST API - Endpoints with CRUD operations (create, read, update and delete);
* Controller, Service, DAO and Model class layers with Spring framework; 
* DAO class using CRUD Operations Interface from Spring Data (CrudRepository);
* [H2 Database](https://www.h2database.com/html/main.html) - Open-source in-memory SQL Database;
* [Project Lombok](https://projectlombok.org/) - Java library that abstract getter and setter methods in POJO classes.

## Build and Run
To build and run the application, type:

```
mvn spring-boot:run
```

## Testing REST API operations with cURL

**Important:** `Content-Type: application/json` header must be present to use API.

### Get all rows
```
curl -H "Content-Type: application/json" -X GET http://localhost:8080/book
```
When succeed, 200 Status code and all rows are returned.

### Get one row
```
curl -H "Content-Type: application/json" -X GET http://localhost:8080/book/2
```
When succeed, 200 Status code and one row are returned.  
When not found, 404 Status code is returned.

### Insert one row
```
curl -d "@data.json" -H "Content-Type: application/json" -X POST http://localhost:8080/book
```
Before execute the curl, create `data.json` text file with the following content: 

```
{"id": 4, "title": "From Earth to Moon", "description": "Jules Verne's classic tale of the first trip from the Earth to the Moon", "author": "Jules Verne", "edition": "1st Edition", "pages": 112, "launchDate": "1950-01-01", "status": "Available", "publisher": "Longman"}
```
When succeed, 201 Status code is returned and one new row is created.

### Update one row
```
curl -d "@data.json" -H "Content-Type: application/json" -X PUT http://localhost:8080/book
```
Before execute the curl, create `data.json` text file with the following content: 

```
{"id": 2, "title": "Cosmos", "description": "This book is about science in its broadest human context, how science and  civilization grew up together", "author": "Carl Sagan", "edition": "1st Edition", "pages": 365, "launchDate": "1980-01-01", "status": "Unavailable", "publisher": "Random House"}
```
When succeed, 202 Status code is returned and one row is updated.  
When not found, 404 Status code is returned.

### Delete one row
```
curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/book/2
```
When succeed, 204 Status code is returned and one row is deleted.  
When not found, 404 Status code is returned.


