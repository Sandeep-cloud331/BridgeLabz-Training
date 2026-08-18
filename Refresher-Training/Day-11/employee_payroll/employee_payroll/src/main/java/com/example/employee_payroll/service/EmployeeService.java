package com.example.employee_payroll.service;

import com.example.employee_payroll.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
    List<Employee> findByDepartment(String department);
    List<Employee> findByDepartmentAndSalaryRange(String department, BigDecimal min, BigDecimal max);
}
