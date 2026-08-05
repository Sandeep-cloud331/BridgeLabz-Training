package com.clinic.dao;

import com.clinic.dto.Patient;

public interface PatientDao {
    int insertPatient(Patient patient);
    Patient getPatientById(int id);
}
