package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/")
    public String test(){
        return "helo word";
    }
    //api them nv
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return  iEmployeeService.addEmployee(employee);
    }
    //api sua nv
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return iEmployeeService.updateEmployee(employee);
    }
    //api xoa nv
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployEE(@PathVariable("id") Long id){
        return iEmployeeService.deleteEmployee(id);
    }
    // lay tat ca
    @GetMapping("/list")
    public List<Employee> getAll(){
        return iEmployeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id){
        return iEmployeeService.getOne(id);
    }
}
