# Refresher Training

This repository contains my notes, practice programs, and assignments from the Refresher Training.

---

## Day 1 - Database Programming

### Topics Covered

- DBMS Fundamentals
- RDBMS Basics
- Types of Databases
  - Relational Databases
  - Non-Relational Databases
  - When to use each
- Introduction to MySQL
- DDL (Data Definition Language)
- DML (Data Manipulation Language)

### Practical Work

- Set up MySQL environment
- Created and configured MySQL
- Started designing an ER Diagram for the Health Clinic application
  - Patients
  - Doctors
  - Appointments

---
## Day 2 - Database Design & Optimization

### Topics Covered

- Indexing
  - Clustered Index
  - Non-Clustered Index
  - Primary Index
  - Composite Index
  - Unique Index
  - Advantages and Use Cases
- ER Diagram
  - Entities
  - Attributes
  - Relationships
  - Cardinality
- Database Normalization
  - First Normal Form (1NF)
  - Second Normal Form (2NF)
  - Third Normal Form (3NF)
  - Fourth Normal Form (4NF)

### Practical Work

- Designed the ER Diagram for the Health Clinic database by MySQL Workbench
- Created tables based on the ER Diagram
- Applied normalization (1NF to 4NF) using sample tables
- Practiced creating indexes to improve query performance

---
## Day 3 - Advanced SQL

### Topics Covered

- SQL Joins
  - INNER JOIN
  - Many-to-Many Relationships
  - Junction Tables (`doctor_specializations`)

- Stored Procedures
  - Creating Stored Procedures
  - IN Parameters

- Triggers
  - BEFORE INSERT Trigger
  - AFTER UPDATE Trigger
  - BEFORE DELETE Trigger


### Hands-on Practice

- Implemented many-to-many relationship between doctors and specializations.
- Retrieved doctor and specialization details using `JOIN`.
- Created stored procedures to fetch patient appointments and patient count.
- Implemented triggers to:
  - Prevent appointments from being booked in the past.
  - Automatically create visit history after appointment completion.
  - Restrict deletion of patients with active appointments.

## Day 4 - Java JDBC Project (Health Clinic Management System)

### Topics Covered

* JDBC Basics
* Connecting Java with MySQL
* CRUD Operations
* PreparedStatement
* ResultSet
* DAO & DTO Pattern
* Layered Architecture
* Exception Handling

### Project

* Built a **Health Clinic Management System** using Java, JDBC, and MySQL to practice CRUD operations and implement a layered architecture.

## Day 5 - Tomcat, Servlets & Spring Introduction

### Topics Covered

- Apache Tomcat as a Web/Application Server
- Servlet Lifecycle
- Introduction to the Spring Framework
- Spring Core Concepts
  - Inversion of Control (IoC)
  - Dependency Injection (DI)

### Key Learnings

- Understood how Tomcat hosts and runs Java web applications.
- Learned the different phases of the Servlet lifecycle.
- Explored the basics of the Spring Framework.
- Gained an understanding of IoC and Dependency Injection for building loosely coupled applications.

## Day 6 - Spring MVC & Request Handling

### Topics Covered

* Spring MVC architecture — DispatcherServlet, Controllers, and Views
* Request mapping and handling in Spring MVC
* Handling HTTP requests and parameters
* Building REST-style endpoints with Spring MVC

### Project

Built the **Greetings App** using Spring MVC, implementing request mapping and handling to process incoming requests and return appropriate responses.


## Day 7 - Spring REST API & Request Handling

### Topics Covered

* Spring REST API programming
* Building RESTful endpoints
* Request handling patterns
* H2 in-memory database basics
* Distributed Architectures — overview and motivation

### Project

Started developing the **Contacts App backend** with basic REST endpoints.

## Day 8 - API Testing Tools & SDLC Exposure

### Topics Covered

* REST Assured automated API testing
* Automated happy-path and unhappy-path API tests
* JSON Server for mock REST APIs
* Software Development Life Cycle (SDLC)
* Waterfall and Agile SDLC models

### Project

Continued developing the **Contacts App backend** by adding automated REST API tests using **REST Assured**.

* Added tests for successful and failed API requests
* Tested validation and missing-resource scenarios
* Added tests for PUT and DELETE operations
* Added duplicate-email handling and testing
* Set up **JSON Server** as a mock REST API
* Tested GET, POST, and DELETE operations with JSON Server
* Compared JSON Server behavior with the real Contacts App API

### Testing

Implemented automated tests covering:

* GET all contacts
* Create a contact
* Get a contact by ID
* Handle non-existent contacts
* Validate blank names
* Validate invalid phone numbers
* Update contacts
* Delete contacts
* Duplicate email handling

# Day 9 - Backend with Spring Boot

### Topics Covered

* Spring Boot fundamentals
* Spring Boot auto-configuration
* Spring Boot starters and dependency management
* Embedded server and application setup
* Spring Controllers

### Project

* Continued building the **Contacts App** backend using Spring Boot
* Implemented and explored REST API endpoints
* Worked with Spring Boot's auto-configuration and embedded server features

### Key Takeaways

* Understood how Spring Boot simplifies Spring application configuration.
* Learned how starters provide commonly required dependencies.
* Understood how Spring Boot runs applications using an embedded server.
* Learned the basics of creating REST controllers and handling HTTP requests.

# Day 10 - Backend with Spring Boot

## Topics Covered

* Understanding how Spring manages and injects dependencies
* H2 Database integration
* H2 database configuration in Spring Boot
* Understanding in-memory databases for development and testing

## Project

Integrated and configured the **H2 Database** with the Contacts App / Employee Payroll App backend.

The application was configured to connect to an **H2 in-memory database**, allowing database operations without requiring an external database server.

## Key Learning

* How Spring Boot configures a `DataSource`
* How Hibernate connects to and communicates with H2
* Difference between an in-memory database and a persistent database

# Day 11 - Spring Services, JPA & JDBC

### Topics Covered

* **Spring Services** — separating business logic from controllers using the service layer.
* **Spring JPA** — managing database persistence and CRUD operations using JPA repositories.
* **Spring JDBC** — implementing template-based database access with `JdbcTemplate`.
* **RESTful API Design** — building structured REST APIs.
* **Data Persistence** — connecting application logic with relational databases.
* **Template-Based Data Access** — performing database operations using Spring JDBC.

### Projects

* Continued developing the **Contacts App backend**, applying Spring Services, JPA, and JDBC concepts.
* Continued working on the **Employee Payroll App**, adding its basic structure and functionality while applying Spring concepts.

# Day 12 - Spring Boot Logging & Bean Scopes

### Topics Covered

* SLF4J logging in Spring Boot
* Log levels — `INFO`, `DEBUG`, `WARN`, and `ERROR`
* Using `Logger` and `@Slf4j`
* Logging application events and exceptions
* Spring Bean Scopes
* Singleton scope
* Prototype scope
* Understanding the difference between singleton and prototype beans

### Project

Continued working on the **Contacts App backend** by adding proper logging and experimenting with Spring Bean scopes

## Day 13 --- Spring Security & JWT Authentication

### Learned

-   Spring Security fundamentals
-   Authentication using JWT
-   JWT token generation and validation
-   Securing REST APIs
-   User login, registration, and password recovery

### Implemented

-   User Management Module
-   JWT-based login authentication
-   Protected APIs using Spring Security

**Flow:**

``` text
Client → Spring Security → JWT Filter → Controller → Service → Repository → Database
```

------------------------------------------------------------------------

## Day 14 --- Authorization & JPA

### Learned

-   Authentication vs Authorization
-   Securing resources based on the authenticated user
-   JPA entity relationships
-   User--Note relationship

### Implemented

-   Notes creation and deletion
-   User-specific notes
-   Authorization checks for note operations

**Relationship:**

``` text
User (1) ────────< Note (Many)
```

------------------------------------------------------------------------

## Day 15 --- Pin, Archive, Trash, Search & Tags

### Learned

-   REST endpoint design
-   Note state management
-   Search and filtering
-   Tags / Labels

### Implemented

-   Pin notes
-   Archive notes
-   Move notes to trash
-   Search and filter notes
-   Add and manage tags

**Example:**

``` text
Note
 ├── Pinned
 ├── Archived
 ├── Trashed
 └── Tags
```

------------------------------------------------------------------------

## Overall Learning

By the end of Days 13--15, Fundoo Notes includes:

-   Spring Security
-   JWT Authentication
-   Authorization
-   JPA Relationships
-   Notes Management
-   Pin / Archive / Tr
-   Search & Filter
-   Tags / Labels
-   Secure REST APIs


## Day 16 --- JMS & Redis Caching

### Learned

-   JMS (Java Message Service) for asynchronous, non-blocking processing
-   Background processing using message queues
-   Redis caching
-   Token caching to improve authorization performance

### Implemented

-   Reminder & Notification Module using JMS
-   Redis-based token caching

**Flow:**

``` text
Request → JMS Queue → Background Consumer → Reminder/Notification
```

------------------------------------------------------------------------

## Day 17 --- RabbitMQ & Spring Batch

### Learned

-   RabbitMQ message queuing fundamentals
-   Asynchronous background processing
-   Spring Batch for batch processing
-   Excel import/export

### Implemented / Explored

-   File Attachment Module (optional)
-   RabbitMQ for background/asynchronous operations
-   Excel processing using Spring Batch

**Flow:**

``` text
Request → RabbitMQ → Consumer → Background Processing
```


