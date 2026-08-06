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
