package com.example.employee_payroll.dao;

import com.example.employee_payroll.entity.Employee;

import java.util.List;

// Problem 5 — hand-written data-access interface backed by JdbcTemplate.
// Compare with EmployeeRepository (JpaRepository): zero boilerplate vs explicit SQL.
public interface EmployeeDAO {
    List<Employee> getAll();
    Employee getById(int id);
}
