package com.clinic;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.PatientDao;
import com.clinic.dao.PatientDaoImpl;
import com.clinic.dto.Patient;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        PatientDao dao = new PatientDaoImpl();
        int newId = dao.insertPatient(new Patient("Ramesh", "Kumar","22222","male", "ramesh@email.com","1234567809",false,"22222"));
        System.out.println("Inserted with ID: " + newId);
        Patient found = dao.getPatientById(newId);
        System.out.println(found);
    }
}
