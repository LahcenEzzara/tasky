# **Tasky - Task Management System**

## **Version 2.0**

Tasky is a simple yet powerful task management system built with **Spring Boot** and **MySQL**. It allows users to manage tasks and users through a RESTful API. This version includes significant improvements in code quality, security, and maintainability, along with enhanced test coverage and documentation.

---

## **Features**

### **Task Management**
- **Create, read, update, and delete tasks** with details such as title, description, priority, and due date.
- Assign tasks to specific users.
- Mark tasks as completed to track progress.

### **User Management**
- **Create, read, update, and delete users** with details such as name and email.
- Retrieve user-specific information, including assigned tasks.

### **API Endpoints**
- RESTful API for tasks and users.
- Secure endpoints with role-based access control.

### **Code Quality Improvements**
- Refactored code to eliminate **code smells** and **duplication**.
- Enhanced **security** by implementing password protection and secure coding practices.
- Improved **error handling** with global exception management.

### **Testing**
- Comprehensive **unit tests** and **integration tests** for all critical functionality.
- Increased **test coverage** to **95.6%** using **JUnit 5** and **Mockito**.
- Added **assertions** to validate the behavior of methods.

### **Documentation**
- Added **Javadoc** comments for all public methods and classes.
- Improved **inline comments** to explain complex logic.
- Updated **README** with detailed setup and usage instructions.

---

## **Technologies**

- **Backend**: Spring Boot 3.3.7
- **Database**: MySQL
- **Build Tool**: Maven
- **Testing**: JUnit 5, Mockito, Jacoco (for coverage)
- **Code Quality**: SonarQube (for static code analysis)
- **API Documentation**: Postman (for testing)
- **Version Control**: Git

---

## **Setup Instructions**

### **Prerequisites**
- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.8 or higher

### **Steps to Run the Application**
1. Clone the repository:
   ```bash
   git clone https://github.com/LahcenEzara/tasky.git
   ```
2. Navigate to the project directory:
   ```bash
   cd tasky
   ```
3. Configure the database:
  - Update the `application.properties` file with your MySQL credentials.
  - Create a database named `tasky_db` in MySQL.
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```
6. Access the API at `http://localhost:8080`.

---

## **API Endpoints**

### **Task Endpoints**
- **GET** `/tasks` - Retrieve all tasks.
- **POST** `/tasks` - Create a new task.
- **PUT** `/tasks/{id}` - Update an existing task.
- **DELETE** `/tasks/{id}` - Delete a task.

### **User Endpoints**
- **GET** `/users` - Retrieve all users.
- **POST** `/users` - Create a new user.
- **PUT** `/users/{id}` - Update an existing user.
- **DELETE** `/users/{id}` - Delete a user.
- **GET** `/users/{id}/email` - Retrieve the email of a specific user.

---

## **Code Quality and Testing**

### **SonarQube Integration**
- Integrated **SonarQube** for continuous code quality analysis.
- Addressed **bugs**, **vulnerabilities**, and **code smells** identified by SonarQube.
- Achieved a **Quality Gate Pass** in Version 2.0.

### **Test Coverage**
- Increased test coverage to **95.6%**.
- Added comprehensive unit tests for controllers, services, and repositories.
- Used **Mockito** for mocking dependencies during testing.

---

## **Future Work**
- Continue increasing test coverage to ensure all edge cases are covered.
- Explore additional SonarQube features, such as custom quality profiles and rules.

---
Copyright © 2025 **Tasky Team**. All rights reserved.