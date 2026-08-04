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
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
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
     patient_id INT NOT NULL,
     doctor_id INT NOT NULL,
     appointment_date DATE unique,
     status ENUM('Scheduled','Completed','Cancelled'),
     foreign key(patient_id)
     references patients(patient_id),
	 foreign key(doctor_id)
     references doctors(doctor_id)
     
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

use health_clinic_db;
select * from doctors;

update doctors 
set specialization='Neurology'
where doctor_id=3;

select * from patients where first_name like '%a';

use health_clinic_db;

show databases;

create index idx_patient_id on appointments(patient_id);

create index idx_phone_number on patients(phone_number);

create index idx_doctor_date on appointments(doctor_id, appointment_date);

CREATE INDEX idx_covering 
ON appointments(doctor_id, appointment_date, status);

SELECT doctor_id, appointment_date, status
FROM appointments
WHERE doctor_id = 3;

EXPLAIN SELECT * FROM doctors WHERE doctor_id = 1;


CREATE TABLE doctor_specializations (
    doctor_id INT NOT NULL,
    specialization_id INT NOT NULL,
    PRIMARY KEY (doctor_id, specialization_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
    FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id)
);

INSERT INTO doctor_specializations VALUES
(2, 1), -- Dr. Rao → Cardiology
(3, 2), -- Dr. Iyer → Pediatrics
(4, 3), -- Dr. Singh → Orthopedics
(3, 4); -- Dr. Iyer → Neurology

SELECT d.first_name, d.last_name, s.name AS specialization
FROM doctors d
JOIN doctor_specializations ds ON d.doctor_id = ds.doctor_id
JOIN specializations s ON ds.specialization_id = s.specialization_id;


DELIMITER //
create procedure GetPatientAppointments(in pid INT)
begin 
	select a.appointment_date, d.first_name as doctor_name, d.last_name as doctor_last
    from appointments a
    join doctors d on a.doctor_id = d.doctor_id
    where a.patient_id = pid;
end //
DELIMITER ;

CALL GetPatientAppointments(1);

SHOW PROCEDURE STATUS WHERE Db = 'health_clinic_db';

DELIMITER //
CREATE PROCEDURE GetPatientCount(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM patients;
END //
DELIMITER ;

CALL GetPatientCount(@count);
SELECT @count;

DELIMITER //
CREATE TRIGGER before_appointment_insert
BEFORE INSERT ON appointments
FOR EACH ROW
BEGIN
    IF NEW.appointment_date < CURDATE() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot book an appointment in the past';
    END IF;
END //
DELIMITER ;

INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2020-01-01', 'Scheduled');

INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2026-08-10', 'Scheduled');

SELECT * FROM appointments;
CREATE TABLE visit_history (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT NOT NULL,
    visit_notes VARCHAR(255),
    visit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id) REFERENCES appointments(id)
);


DELIMITER //
CREATE TRIGGER after_appointment_update
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN
    IF NEW.status = 'Completed' AND OLD.status != 'Completed' THEN
        INSERT INTO visit_history(appointment_id, visit_notes, visit_date)
        VALUES (NEW.id, 'Auto-generated visit record', NOW());
    END IF;
END //
DELIMITER ;

INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2026-08-04', 'Scheduled');

UPDATE appointments
SET status = 'Completed'
WHERE id = 1;

SELECT * FROM appointments;

DELIMITER //
CREATE TRIGGER before_patient_delete
BEFORE DELETE ON patients
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM appointments WHERE patient_id = OLD.patient_id AND status='Scheduled') THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete a patient with active appointments';
    END IF;
END //
DELIMITER ;

INSERT INTO patients(first_name, last_name, date_of_birth, gender, phone_number, email)
VALUES ('Test', 'Patient', '1990-01-01', 'Male', '1234567890', 'test@email.com');

INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
VALUES (LAST_INSERT_ID(), 1, '2026-08-20', 'Scheduled');

DELETE FROM patients WHERE patient_id = 4;


