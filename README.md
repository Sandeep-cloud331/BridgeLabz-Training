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
