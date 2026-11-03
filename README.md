# Software Engineer API

A Spring Boot REST API for storing and retrieving software engineer profiles, including each engineer's name and technology stack. Data is persisted in PostgreSQL.

## Features

- List all software engineers
- Retrieve a software engineer by ID
- Add a software engineer
- Persist data with Spring Data JPA and PostgreSQL

## Technology stack

- Java 17
- Spring Boot 4.0.9
- Spring MVC
- Spring Data JPA
- PostgreSQL 16
- Maven

## Prerequisites

- JDK 17 or later
- Docker with Docker Compose

## Run locally

1. Start PostgreSQL:

   ```sh
   docker compose up -d
   ```

   This starts PostgreSQL on `localhost:5333` and creates the `mydatabase` database with the local development credentials `root` / `root`.

2. Run the application, overriding the datasource settings to match the database created by Docker Compose.

   **Windows PowerShell:**

   ```powershell
   $env:SPRING_DATASOURCE_URL = "jdbc:postgresql://localhost:5333/mydatabase"
   $env:SPRING_DATASOURCE_USERNAME = "root"
   $env:SPRING_DATASOURCE_PASSWORD = "root"
   .\mvnw.cmd spring-boot:run
   ```

   **macOS / Linux:**

   ```sh
   SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5333/mydatabase \
   SPRING_DATASOURCE_USERNAME=root \
   SPRING_DATASOURCE_PASSWORD=root \
   ./mvnw spring-boot:run
   ```

The API is available at `http://localhost:8080`. Hibernate creates or updates the database schema on startup.

## API

Base path: `/api/v1/software-engineers`

### List all engineers

```http
GET /api/v1/software-engineers
```

### Get an engineer by ID

```http
GET /api/v1/software-engineers/{id}
```

### Add an engineer

```http
POST /api/v1/software-engineers
Content-Type: application/json
```

Example request:

```json
{
  "name": "Alex",
  "techStack": "Java, Spring Boot, PostgreSQL"
}
```

The generated ID is returned with the saved engineer.

## Run tests

**Windows PowerShell:**

```powershell
.\mvnw.cmd test
```

**macOS / Linux:**

```sh
./mvnw test
```

## Stop PostgreSQL

```sh
docker compose down
```

Docker Compose keeps database files in the `db-data` volume, so the data remains when the container is stopped.
