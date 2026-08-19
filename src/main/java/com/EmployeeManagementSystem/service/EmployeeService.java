package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee emp);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee updateByempId(Long id,Employee employee);
    void deleteByempId(Long id);
}
