package com.example.employee_payroll.controller;

import com.example.employee_payroll.entity.Employee;
import com.example.employee_payroll.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.save(employee));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Problem 4 — @Query endpoint
    // GET /employees/search?department=Engineering&min=50000&max=100000
    @GetMapping("/search")
    public List<Employee> search(
            @RequestParam String department,
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return employeeService.findByDepartmentAndSalaryRange(department, min, max);
    }

    // Problem 6 — batch path that simulates a non-HTTP caller (e.g. a scheduled job).
    // Because validation lives in EmployeeService.save(), NOT in this controller,
    // the salary-positive rule is enforced here too — the batch path cannot bypass it.
    // If you moved the check into the HTTP create() method above, this endpoint would
    // accept negative salaries, which is the bug the problem asks you to observe.
    @PostMapping("/batch")
    public ResponseEntity<?> batchSave(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.save(employee));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
