package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public boolean deleteEmployee(Long id);
    public List<Employee> getAll();
    public Employee getOne(Long id);
}
