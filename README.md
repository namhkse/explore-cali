# ExploreCali JPA

ExploreCali JPA is a Spring Boot application that demonstrates the use of Java Persistence API (JPA) for managing travel-related data. The project is designed to help users learn how to build RESTful APIs with Spring Data JPA, Hibernate, and an embedded database.

## Features

- CRUD operations for tours and packages
- RESTful API endpoints
- Spring Data JPA integration
- Embedded H2 database for development
- Easy configuration and extensibility

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- Git

## Getting Started

1. **Clone the repository:**
   ```
   git clone https://github.com/yourusername/explorecali-jpa.git
   cd explorecali-jpa
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn spring-boot:run
   ```

4. **Access the API:**
   - Visit [http://localhost:8080/api/tours](http://localhost:8080/api/tours) for tour endpoints.
   - Visit [http://localhost:8080/h2-console](http://localhost:8080/h2-console) for the H2 database console.

## Project Structure

- `src/main/java`: Java source code
- `src/main/resources`: Configuration files
- `src/test/java`: Unit and integration tests

## API Endpoints

| Method | Endpoint             | Description           |
|--------|----------------------|-----------------------|
| GET    | /api/tours           | List all tours        |
| POST   | /api/tours           | Create a new tour     |
| GET    | /api/tours/{id}      | Get tour by ID        |
| PUT    | /api/tours/{id}      | Update tour           |
| DELETE | /api/tours/{id}      | Delete tour           |

## License

This project is licensed under the MIT License.

## Author