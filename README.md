# 🎓 Student Grade Management System - Backend

A secure and scalable REST API built with **Spring Boot** for managing students, subjects, marks, attendance, and user authentication.

This project serves as the backend of the Student Grade Management System and follows a layered architecture using Spring Boot, Spring Security, JWT Authentication, Hibernate/JPA, and MySQL.

---

https://student-grade-management-ui.vercel.app

---

# ✨ Features

- 🔐 JWT Authentication & Authorization
- 👤 User Registration & Login
- 🎓 Student Management (CRUD)
- 📚 Subject Management (CRUD)
- 📝 Marks Management (CRUD)
- 📅 Attendance Management (CRUD)
- 📊 Dashboard Statistics API
- ✅ Input Validation
- 🔒 Password Encryption using BCrypt
- 🌐 RESTful APIs
- 📖 Swagger API Documentation
- ☁️ Railway Deployment

---

# 🛠 Tech Stack

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT (JSON Web Token)
- Maven

### Database

- MySQL

### API Testing

- Postman
- Swagger UI

### Deployment

- Railway

---

# 📁 Project Structure

```
src
│
├── config
├── controller
├── dto
├── entity
├── repository
├── response
├── security
├── service
├── util
└── StudentGradeManagementApplication.java
```

---

# 🔑 Authentication

The application uses **JWT (JSON Web Token)** authentication.

After successful login, a JWT token is generated and must be included in every protected API request.

Example Header

```
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# 📌 REST APIs

## Authentication

| Method | Endpoint |
|---------|-----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

---

## Students

| Method | Endpoint |
|---------|-----------|
| GET | /api/students |
| GET | /api/students/{id} |
| POST | /api/students |
| PUT | /api/students/{id} |
| DELETE | /api/students/{id} |

---

## Subjects

| Method | Endpoint |
|---------|-----------|
| GET | /api/subjects |
| GET | /api/subjects/{id} |
| POST | /api/subjects |
| PUT | /api/subjects/{id} |
| DELETE | /api/subjects/{id} |

---

## Marks

| Method | Endpoint |
|---------|-----------|
| GET | /api/marks |
| GET | /api/marks/{id} |
| POST | /api/marks |
| PUT | /api/marks/{id} |
| DELETE | /api/marks/{id} |

---

## Attendance

| Method | Endpoint |
|---------|-----------|
| GET | /api/attendance |
| GET | /api/attendance/{id} |
| POST | /api/attendance |
| PUT | /api/attendance/{id} |
| DELETE | /api/attendance/{id} |

---

## Dashboard

| Method | Endpoint |
|---------|-----------|
| GET | /api/dashboard |

---

# ⚙️ Installation

Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/student-grade-management-backend.git
```

Move into the project

```bash
cd student-grade-management-backend
```

Configure MySQL in

```
application.properties
```

Run the project

```bash
mvn spring-boot:run
```

---

# 📖 Swagger Documentation

After running the project locally

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🔒 Security

- Spring Security
- JWT Authentication
- BCrypt Password Encoding
- Stateless Session Management
- Role-based authentication ready

---

# 📈 Future Enhancements

- Role-Based Access Control (Admin, Teacher, Student)
- Email Notifications
- Student Performance Analytics
- PDF Report Generation
- Excel Export
- Search & Filtering
- Pagination
- Audit Logs

---

# 👨‍💻 Author

**Aditya Das**

B.Sc. Computer Science Graduate

Java Backend Developer | Spring Boot | MySQL | React

GitHub:
https://github.com/YOUR_USERNAME

LinkedIn:
https://www.linkedin.com/in/YOUR_LINKEDIN

---

# ⭐ If you found this project useful, consider giving it a star.
