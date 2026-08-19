package com.EmployeeManagementSystem.controller;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeService empser;
    @PostMapping("/add")
    public String addemployee(@RequestBody Employee emp){
        empser.addEmployee(emp);
        return "Employee Added Sucessfully";
    }
    @GetMapping("/all")
    public List<Employee> getAll(){
        return empser.getAll();
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return empser.getById(id);
    }
    @PutMapping("/{id}")
    public String updateByid(@PathVariable Long id,@RequestBody Employee employee){
        empser.updateByempId(id,employee);
        return "Updated Sucessfully";
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        empser.deleteByempId(id);
        return "Deleted Sucessfully";
    }

}

