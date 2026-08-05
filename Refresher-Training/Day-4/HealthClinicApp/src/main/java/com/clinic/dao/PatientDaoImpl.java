package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;

import java.sql.*;

public class PatientDaoImpl implements PatientDao {

    @Override
    public int insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (first_name, last_name, email) VALUES (?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, patient.getFirst_name());
            pstmt.setString(2, patient.getLast_name());
            pstmt.setString(3, patient.getEmail());
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Patient p = new Patient();
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }
}
