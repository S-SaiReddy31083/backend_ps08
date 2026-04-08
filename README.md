# ⚙️ Backend - Citizen–Politician Interaction System

## 📌 Project Overview

The backend of the **Citizen–Politician Interaction System** is responsible for handling business logic, API development, database interaction, and user authentication. It is built using **Spring Boot** and exposes RESTful APIs to communicate with the frontend.

---

## 🚀 Features

### 🔐 Authentication & Authorization

* User registration and login
* Role-based access (Citizen, Politician, Admin, Moderator)
* Secure API handling

### 📢 Issue Management

* Create new issues
* Retrieve all issues
* Vote on issues
* Categorize issues

### 📊 Analytics Support

* Provide data for charts and reports
* Category-wise issue statistics

### 🧑‍💼 Admin & Moderator Controls

* Manage users
* Monitor issues
* Update issue status

---

## 🧱 Tech Stack

| Technology      | Purpose                   |
| --------------- | ------------------------- |
| Java            | Core programming language |
| Spring Boot     | Backend framework         |
| Spring Web      | REST API development      |
| Spring Data JPA | Database interaction      |
| Hibernate       | ORM tool                  |
| MySQL / H2      | Database                  |
| Maven           | Dependency management     |

---

## 📂 Project Structure

```
backend/
│
├── src/main/java/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   └── config/
│
├── src/main/resources/
│   ├── application.properties
│
└── pom.xml
```

---

## 🔗 API Endpoints

### 🔐 Authentication APIs

* `POST /api/auth/signup` → Register a new user
* `POST /api/auth/login` → Authenticate user

### 📢 Issue APIs

* `GET /api/issues` → Get all issues
* `POST /api/issues` → Create a new issue
* `POST /api/issues/{id}/vote` → Vote on an issue
* `GET /api/issues/top` → Get top issues

---

## ⚙️ How It Works

1. Frontend sends HTTP request to backend API
2. Controller receives request
3. Service layer processes business logic
4. Repository interacts with database
5. Response is returned in JSON format

---

## 🗄️ Database Design

### 👤 Users Table

* id
* name
* email
* password
* role

### 📢 Issues Table

* id
* title
* description
* category
* location
* status

### 👍 Votes Table

* id
* user_id
* issue_id

---

## 🔐 Security (Basic)

* Input validation
* Error handling
* Role-based authorization (basic level)

---

## 🧪 Running the Backend

1. Clone the repository
2. Open in IDE (IntelliJ / Eclipse)
3. Configure database in `application.properties`
4. Run the Spring Boot application

Default server:

```
http://localhost:9191
```

---

## 🔄 Integration with Frontend

The backend communicates with frontend via REST APIs. All responses are sent in JSON format and consumed using Fetch API.

---

## ⚠️ Requirements

* Java 8+
* Maven
* MySQL (or H2 for testing)

---

## 📈 Future Enhancements

* JWT authentication
* Role-based security using Spring Security
* Real-time notifications
* File storage (cloud integration)

---

## 👨‍💻 Author

Developed as part of academic project: **Citizen–Politician Interaction System**

---

## 📄 License

This project is for educational purposes only.
