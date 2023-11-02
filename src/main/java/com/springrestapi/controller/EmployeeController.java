package com.springrestapi.controller;

import com.springrestapi.model.Employee;
import com.springrestapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // localhost:8080/api/v1/employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    // localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<Employee>(employeeService.getSingleEmployee(id), HttpStatus.OK);
    }

    // localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // localhost:8080/api/v1/employees/1
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    // localhost:8080/api/v1/employees?id=1
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameContaining")
    public ResponseEntity<List<Employee>> getEmployeesByNameContaining(@RequestParam String keyword) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameContaining(keyword), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByAge")
    public ResponseEntity<List<Employee>> getEmployeesByAge(@RequestParam Integer age) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByAge(age), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameOrLocation/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesNameOrLocation(@PathVariable String name, @PathVariable String location) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<String> deleteEmployeesByName(@PathVariable String name) {
        return new ResponseEntity<String>(employeeService.deleteEmployeesByName(name) + " records affected!", HttpStatus.OK);
    }
}