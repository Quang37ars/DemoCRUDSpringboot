package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee != null){
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employee != null){
            Employee employee1 = employeeRepository.getReferenceById(employee.getId());
            if(employee1 != null){
                employee1.setName(employee.getName());
                employee1.setAddress(employee.getAddress());
                return employeeRepository.save(employee1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.getReferenceById(id);
        if(employee != null){
            employeeRepository.delete(employee);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getOne(Long id) {
        return employeeRepository.findById(id).get();
    }
}
