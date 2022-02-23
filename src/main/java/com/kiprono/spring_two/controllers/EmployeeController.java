package com.kiprono.spring_two.controllers;

import com.kiprono.spring_two.Services.EmployeeService;
import com.kiprono.spring_two.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("api/employees")
    public List<Employee> getEmployee(){
        return service.getEmployees();
    }

    @PostMapping("api/employees")
    public void addNew(@RequestBody Employee employee) {
       this.service.addEmployee(employee);
    }

    @DeleteMapping( path = "/api/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        this.service.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/api/employees/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId, String firstName, String lastName, String email){
        this.service.updateEmployee(employeeId, firstName, lastName, email);
    }
}
