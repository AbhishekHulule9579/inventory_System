Inventory Management System API
Project Description
This project is a backend-heavy RESTful API designed to manage products in a warehouse. It provides full CRUD (Create, Read, Update, Delete) functionality for products and includes robust business logic for handling inventory stock levels.

The core features include:

Managing products with a name, description, and stock quantity.

Endpoints to safely increase and decrease product stock.

Business logic that prevents stock from ever going below zero.

A bonus feature to list all products that have fallen below their specified low-stock threshold.

This API is built with Java and the Spring Boot framework, using Spring Data JPA for database interaction and a MySQL database for persistence.

How to Set Up and Run Locally
Prerequisites
Java 17 or later

Apache Maven

MySQL Server

An API testing tool like Postman or Insomnia.

1. Clone the Repository
git clone <your-repository-url.git>
cd inventory-system

2. Configure the Database
Open your MySQL server and create a new database.

CREATE DATABASE inventory_db;

Navigate to src/main/resources/application.properties.

Update the following properties with your MySQL username and password.

spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=your_username
spring.datasource.password=your_password

3. Run the Application
You can run the application using the Maven wrapper:

./mvnw spring-boot:run

The API will start on http://localhost:8080.

How to Use the API (Endpoints)
The base URL for all endpoints is http://localhost:8080/api/products.

Method

Endpoint

Description

Request Body Example

POST

/

Creates a new product.

{"name": "Laptop", "description": "A gaming laptop", "stockQuantity": 50, "lowStockThreshold": 10}

GET

/

Retrieves a list of all products.

(None)

GET

/{id}

Retrieves a single product by its ID.

(None)

PUT

/{id}

Updates an existing product.

{"name": "Laptop Pro", "description": "A powerful laptop for professionals", "stockQuantity": 45, "lowStockThreshold": 15}

DELETE

/{id}

Deletes a product by its ID.

(None)

POST

/{id}/increase-stock

Increases the stock of a product.

{"amount": 10}

POST

/{id}/decrease-stock

Decreases the stock of a product.

{"amount": 5}

GET

/low-stock

Lists all products below their low-stock threshold.

(None)

How to Run Test Cases
(Note: This section is for the bonus feature. You would add instructions here after writing unit tests).

To run the unit tests for the service layer, use the following Maven command:

./mvnw test

Design Choices & Assumptions
Framework: Chose Spring Boot for its rapid development capabilities, embedded server, and robust ecosystem for building REST APIs.

Architecture: Implemented a standard 3-layer architecture (Controller, Service, Repository) to separate concerns and improve maintainability.

Database: Used Spring Data JPA and Hibernate for ORM, which simplifies database interactions. ddl-auto is set to update for development convenience, allowing the schema to evolve with the entity classes.

Error Handling: Specific exceptions (IllegalArgumentException, IllegalStateException) are thrown from the service layer for invalid operations (e.g., negative stock amount, insufficient stock). The controller catches these and returns a 400 Bad Request status with a clear error message.

Stock Operations: Created dedicated endpoints for increasing/decreasing stock to ensure these critical operations are handled transactionally and with proper validation, rather than allowing direct manipulation of the stockQuantity field via the generic PUT endpoint.
