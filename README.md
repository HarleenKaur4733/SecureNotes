
## Secure Notes - Backend

**Secure Notes** is a RESTful backend application built with **Spring Boot** that allows users to create, manage, and access personal notes securely. The application demonstrates modern **authentication and authorization practices using Spring Security and JWT (JSON Web Tokens)**.

The system supports **role-based access control**, where users can register, authenticate using JWT tokens, and perform actions based on their assigned roles.

---

### Key Features

* User registration and authentication
* Secure login using **JWT-based stateless authentication**
* **Role-based authorization** (Admin and User)
* CRUD operations for notes
* Users can access only their own notes
* Admins can manage all users
* Secure endpoints using **Spring Security**
* Password encryption using **BCrypt**
* Method-level security using `@PreAuthorize`

---

### Tech Stack

* **Java**
* **Spring Boot**
* **Spring Security**
* **JWT (JSON Web Tokens)**
* **Spring Data JPA**
* **MySQL**
* **Maven**

---

### Security Architecture

The application uses **stateless authentication with JWT**.

1. Users authenticate via the login endpoint.
2. Upon successful authentication, the server generates a **JWT token**.
3. The client sends this token in the `Authorization` header for every request.
4. A **custom JWT filter** validates the token and extracts the user identity.
5. Spring Security authorizes access to endpoints based on user roles.

---

### Authorization

The application supports two roles:

| Role  | Permissions                                      |
| ----- | ------------------------------------------------ |
| USER  | Create, view, update, and delete their own notes |
| ADMIN | View and manage all users                        |

Authorization is implemented using:

```java
@PreAuthorize("hasRole('ADMIN')")
```

This ensures only authorized users can access restricted resources.

---

### API Security Flow

1. User logs in and receives a JWT token.
2. The token is included in the `Authorization` header:

```
Authorization: Bearer <JWT_TOKEN>
```

3. The JWT filter validates the token on every request.
4. Spring Security sets the authenticated user in the `SecurityContext`.
5. Role-based authorization rules determine access to protected endpoints.

---

### Learning Outcomes

This project demonstrates practical implementation of:

* Spring Security architecture
* Stateless authentication with JWT
* Security filter chains
* Custom authentication filters
* Role-based authorization
* Method-level security with `@PreAuthorize`

---
