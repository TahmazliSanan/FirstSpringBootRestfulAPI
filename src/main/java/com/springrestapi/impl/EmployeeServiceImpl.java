package com.springrestapi.impl;

import com.springrestapi.model.Employee;
import com.springrestapi.repository.EmployeeRepository;
import com.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found!");
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByNameContaining(String keyword) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return employeeRepository.findByNameContaining(keyword, sort);
    }

    @Override
    public List<Employee> getEmployeeByAge(Integer age) {
        return employeeRepository.findByAge(age);
    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return employeeRepository.findByNameOrLocation(name, location);
    }

    @Override
    public Integer deleteEmployeesByName(String name) {
        return employeeRepository.deleteByName(name);
    }
}