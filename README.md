# 📚 Library Management System

A production-ready RESTful backend application built with **Spring Boot 3**, **Spring Data JPA**, **Hibernate**, and **PostgreSQL**. This project manages Authors and Books, demonstrating relational data modeling with a Many-to-One mapping.

---

## 🏗️ Architecture & Data Flow

The application follows a clean 4-tier layered architecture:

```

[ HTTP Client ] ──> [ Controller Layer ] ──> [ Service Layer ] ──> [ Repository Layer ] ──> [ PostgreSQL Database ]

```

- **Controller Layer (`/controller`)**: Handles incoming HTTP requests and shapes REST API responses.
- **Service Layer (`/service`)**: Contains core business logic and transaction boundaries.
- **Repository Layer (`/repository`)**: Leverages Spring Data JPA interfaces for database operations.
- **Model Layer (`/model`)**: Defines JPA entities mapped to database tables using Hibernate.

---

## 🛠️ Tech Stack

- **Language:** Java 17 / 21
- **Framework:** Spring Boot 3
- **ORM / Database Access:** Spring Data JPA, Hibernate
- **Database:** PostgreSQL
- **Tooling & Libraries:** Lombok, Apache Maven, Git/GitHub

---

## 🔌 API Endpoints

### 👤 Authors (`/api/authors`)

| Method | Endpoint       | Description                     |
| :----- | :------------- | :------------------------------ |
| `GET`  | `/api/authors` | Retrieve all registered authors |
| `POST` | `/api/authors` | Create and save a new author    |

#### Request Body (`POST /api/authors`):

```json
{
  "name": "J.K. Rowling",
  "email": "jkrowling@example.com"
}
```

---

### 📖 Books (`/api/books`)

| Method | Endpoint                       | Description                                    |
| ------ | ------------------------------ | ---------------------------------------------- |
| `GET`  | `/api/books`                   | Retrieve all books with their assigned authors |
| `GET`  | `/api/books/author/{authorId}` | Retrieve all books by a specific author ID     |
| `POST` | `/api/books`                   | Add a new book mapped to an author             |

#### Request Body (`POST /api/books`):

```json
{
  "title": "Harry Potter and the Sorcerer's Stone",
  "isbn": "978-0590353427",
  "author": {
    "id": 1
  }
}
```

---

## 🚀 Getting Started

### Prerequisites

- JDK 17 or higher
- PostgreSQL running locally on port `5432`
- Maven wrapper (`./mvnw`)

### Setup Instructions

1. **Clone the repository:**

```bash
git clone [https://github.com/YOUR_USERNAME/library-management.git](https://github.com/YOUR_USERNAME/library-management.git)
cd library-management

```

2. **Configure Database:**
   Create a local PostgreSQL database named `library_db`:

```sql
CREATE DATABASE library_db;

```

3. **Configure `application.properties`:**
   Update `src/main/resources/application.properties` with your local database credentials:

```properties
spring.application.name=library-management
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_POSTGRES_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

```

4. **Run the Application:**

```bash
./mvnw spring-boot:run

```

The application will start on `http://localhost:8080`.
