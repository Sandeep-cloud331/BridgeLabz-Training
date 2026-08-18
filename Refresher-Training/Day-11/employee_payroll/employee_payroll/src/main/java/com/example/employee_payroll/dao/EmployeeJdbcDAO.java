package com.example.employee_payroll.dao;

import com.example.employee_payroll.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// Problem 5 — JdbcTemplate replaces hand-written Connection/PreparedStatement/ResultSet
// boilerplate, but you still write SQL and map columns manually via RowMapper.
// JPA (EmployeeRepository) goes one step further: zero SQL for standard operations.
//
// Comparison:
//   Hand-written JDBC  — you manage Connection, PreparedStatement, ResultSet, exceptions
//   JdbcTemplate       — Spring handles lifecycle; you provide SQL + RowMapper
//   JPA / Spring Data  — you declare method signatures; Spring generates SQL at startup
@Repository
public class EmployeeJdbcDAO implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Employee> employeeRowMapper = (rs, rowNum) -> {
        Employee e = new Employee();
        e.setEmployeeId(rs.getInt("employee_id"));
        e.setName(rs.getString("name"));
        e.setDepartment(rs.getString("department"));
        e.setSalary(rs.getBigDecimal("salary"));
        return e;
    };

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employees", employeeRowMapper);
    }

    @Override
    public Employee getById(int id) {
        List<Employee> results = jdbcTemplate.query(
                "SELECT * FROM employees WHERE employee_id = ?",
                employeeRowMapper,
                id
        );
        return results.isEmpty() ? null : results.get(0);
    }
}
