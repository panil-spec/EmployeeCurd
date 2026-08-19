package com.EmployeeManagementSystem.ServiceImpl;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.EmployeeManagementSystem.repository.EmployeeRepository;
import com.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository emprepo;

    @Override
    public Employee addEmployee(Employee emp) {
        return emprepo.save(emp);
    }

    @Override
    public List<Employee> getAll() {
        return emprepo.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return emprepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is Not Found: "+id) );
    }

    @Override
    public Employee updateByempId(Long id , Employee employee) {
        Employee existingemployee = emprepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found "+id));
        existingemployee.setName(employee.getName());
        existingemployee.setLastname(employee.getLastname());
        existingemployee.setEmail(employee.getEmail());
        return emprepo.save(existingemployee);
    }

    @Override
    public void deleteByempId(Long id) {
         emprepo.deleteById(id);
    }
}
