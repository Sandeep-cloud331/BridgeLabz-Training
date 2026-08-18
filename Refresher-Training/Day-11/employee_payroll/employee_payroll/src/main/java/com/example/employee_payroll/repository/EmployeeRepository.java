package com.example.employee_payroll.repository;

import com.example.employee_payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Deliberate typo demo:
    //   PropertyReferenceException: No property 'deprtment' found for type 'Employee'
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    // Problem 4 — @Query with JPQL. Equivalent derived name would be:
    // findByDepartmentAndSalaryGreaterThanEqualAndSalaryLessThanEqual — too long to be readable.
    @Query("SELECT e FROM Employee e WHERE e.department = :department AND e.salary BETWEEN :min AND :max")
    List<Employee> findByDepartmentAndSalaryRange(
            @Param("department") String department,
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max
    );
}
