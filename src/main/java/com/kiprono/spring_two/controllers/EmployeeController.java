package com.kiprono.spring_two.controllers;

import com.kiprono.spring_two.Services.EmployeeService;
import com.kiprono.spring_two.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        log.info("list");
        return service.getEmployees();
    }

    @PostMapping("/employees")
    public void addNew(@RequestBody Employee employee) {
        log.info("added");
       this.service.addEmployee(employee);
    }

    @DeleteMapping( path = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        log.info("deleted");
        this.service.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/employees/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId, String firstName, String lastName, String email){
        log.info("update");
        this.service.updateEmployee(employeeId, firstName, lastName, email);
    }
}
