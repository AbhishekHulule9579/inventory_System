📦 Inventory Management System API

A backend-heavy RESTful API designed to manage warehouse products with full CRUD operations, stock management, and low-stock tracking. Built with Java Spring Boot and MySQL, this project ensures safe and efficient inventory operations.

🚀 Features

➕ Create, ✏️ Update, 🔍 Read, and ❌ Delete products.

📊 Manage stock with dedicated endpoints to increase/decrease quantity.

🚫 Prevents stock from dropping below zero.

⚠️ Bonus: List all products that are below their low-stock threshold.

🛠️ Tech Stack

Java 17+

Spring Boot (REST API, layered architecture)

Spring Data JPA & Hibernate (ORM)

MySQL (Database persistence)

Maven (Build tool)

⚙️ Setup & Installation
✅ Prerequisites

Java 17 or later

Apache Maven

MySQL Server

Postman / Insomnia (for testing APIs)

📥 Clone the Repository
git clone <your-repository-url.git>
cd inventory-system

🗄️ Configure Database

Create a new database in MySQL:

CREATE DATABASE inventory_db;


Update src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=your_username
spring.datasource.password=your_password

▶️ Run the Application
./mvnw spring-boot:run


API starts at 👉 http://localhost:8080

📡 API Endpoints

Base URL: http://localhost:8080/api/products

Method	Endpoint	Description	Request Body Example
POST	/	Create a new product	{"name": "Laptop", "description": "A gaming laptop", "stockQuantity": 50, "lowStockThreshold": 10}
GET	/	Get all products	None
GET	/{id}	Get product by ID	None
PUT	/{id}	Update a product	{"name": "Laptop Pro", "description": "For professionals", "stockQuantity": 45, "lowStockThreshold": 15}
DELETE	/{id}	Delete a product	None
POST	/{id}/increase-stock	Increase stock	{"amount": 10}
POST	/{id}/decrease-stock	Decrease stock	{"amount": 5}
GET	/low-stock	Get products below threshold	None
🧪 Running Tests

Run unit tests with:

./mvnw test

🏗️ Design Choices & Assumptions

Framework: Spring Boot for rapid development & ecosystem.

Architecture: 3-layer (Controller → Service → Repository).

Database: JPA + Hibernate ORM for simplified interaction.

Error Handling: Service layer throws clear exceptions → Controller maps to meaningful HTTP responses.

Stock Management: Dedicated endpoints for increase/decrease stock to ensure safe and transactional operations.

✨ Future Improvements

✅ Add JWT-based authentication for secure API access.

✅ Implement pagination & sorting for large product lists.

✅ Add Docker support for easy deployment.
