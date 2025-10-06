# 📦 Inventory Management System API  

A **backend-heavy RESTful API** designed to manage warehouse products with full **CRUD operations**, **stock management**, and **low-stock tracking**. Built with **Java Spring Boot** and **MySQL**, this project ensures safe and efficient inventory operations.  

---

## 🚀 Features  

- ➕ Create, ✏️ Update, 🔍 Read, and ❌ Delete products.  
- 📊 Manage stock with dedicated endpoints to **increase/decrease** quantity.  
- 🚫 Prevents stock from dropping **below zero**.  
- ⚠️ Bonus: List all products that are **below their low-stock threshold**.  

---

## 🛠️ Tech Stack  

- **Java 17+**  
- **Spring Boot** (REST API, layered architecture)  
- **Spring Data JPA & Hibernate** (ORM)  
- **MySQL** (Database persistence)  
- **Maven** (Build tool)  

---

## ⚙️ Setup & Installation  

### ✅ Prerequisites  
- Java 17 or later  
- Apache Maven  
- MySQL Server  
- Postman / Insomnia (for testing APIs)  

### 📥 Clone the Repository  
```bash
git clone <your-repository-url.git>
cd inventory-system

## 📡 How to Use the API (Endpoints)

The base URL for all endpoints is:  
👉 **http://localhost:8080/api/products**

| Method | Endpoint               | Description                        | Request Body Example |
|--------|-------------------------|------------------------------------|----------------------|
| POST   | `/`                     | Creates a new product              | ```json {"name": "Laptop", "description": "A gaming laptop", "stockQuantity": 50, "lowStockThreshold": 10} ``` |
| GET    | `/`                     | Retrieves a list of all products   | None |
| GET    | `/{id}`                 | Retrieves a single product by ID   | None |
| PUT    | `/{id}`                 | Updates an existing product        | ```json {"name": "Laptop Pro", "description": "A powerful laptop for professionals", "stockQuantity": 45, "lowStockThreshold": 15} ``` |
| DELETE | `/{id}`                 | Deletes a product by its ID        | None |
| POST   | `/{id}/increase-stock`  | Increases the stock of a product   | ```json {"amount": 10} ``` |
| POST   | `/{id}/decrease-stock`  | Decreases the stock of a product   | ```json {"amount": 5} ``` |
| GET    | `/low-stock`            | Lists all products below threshold | None |

---

## 🧪 How to Run Test Cases

To run the unit tests for the service layer, use the following Maven command:

```bash
./mvnw test
