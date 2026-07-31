show databases;
CREATE DATABASE health_clinic_db;
USE health_clinic_db;
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male','Female','Other'),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100),
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO patients(first_name,last_name,date_of_birth,gender,phone_number,email)
VALUES
('Sandeep','chahar','1999-05-14','Male','9176543210','sandeep@email.com'),
('Anjana','Sharma','1994-08-21','Female','9176543211','anjana@email.com'),
('Ranjana','Verma','2002-01-30','Female','9176543212','ranjana@email.com');

select * from patients;
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(100),
    phone_number VARCHAR(15),
    email VARCHAR(100)
);

INSERT INTO doctors(first_name,last_name,specialization,phone_number,email)
VALUES
('Mahesh','Bhatt','Optometrist','1569658956','bhatt@email.com'),
('Anjali','Rao','Cardiology','9123456780','rao@email.com'),
('Vikram','Iyer','Pediatrics','9123456781','iyer@email.com'),
('Meera','Singh','Orthopedics','9123456782','meera@email.com');

SELECT * FROM doctors;

CREATE TABLE specializations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(255)
);
INSERT INTO specializations(name,description)
VALUES
('Cardiology','Heart Specialist'),
('Pediatrics','Children Specialist'),
('Orthopedics','Bone Specialist');

SELECT * FROM specializations;

CREATE TABLE appointments (
     id INT AUTO_INCREMENT PRIMARY KEY,
     patient_id INT,
     doctor_id INT,
     appointment_date DATE
 );
 INSERT INTO appointments(patient_id,doctor_id,appointment_date)
VALUES
(1,1,'2026-08-02'),
(2,2,'2026-08-03'),
(3,3,'2026-08-04');

SELECT * FROM appointments;

UPDATE patients
SET phone_number='9999999999'
WHERE patient_id=1;

DELETE FROM appointments
WHERE id=3;

DELETE FROM doctors
WHERE doctor_id IN (9,10,11);

DELETE FROM doctors 
WHERE doctor_id = 8;

ALTER TABLE patients
ADD blood_group VARCHAR(10);

ALTER TABLE patients
DROP COLUMN blood_group;

RENAME TABLE doctors TO clinic_doctors;

show tables;

RENAME TABLE clinic_doctors TO doctors;

