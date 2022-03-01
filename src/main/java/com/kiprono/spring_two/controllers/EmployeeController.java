package com.kiprono.spring_two.controllers;

import com.kiprono.spring_two.Services.EmployeeService;
import com.kiprono.spring_two.entities.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@Api(value = "Employee", tags = {"Employees"})
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @ApiOperation(value = "gets all Employees")
    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        log.info("list");
        return service.getEmployees();
    }

    @ApiOperation(value = "adds new employee")
    @PostMapping("/employees")
    public void addNew(@RequestBody Employee employee) {
        log.info("added");
       this.service.addEmployee(employee);
    }

    @ApiOperation(value = "Delete one employee")
    @DeleteMapping( path = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        log.info("deleted");
        this.service.deleteEmployee(employeeId);
    }

    @ApiOperation(value = "update single employee")
    @PutMapping(path = "/employees/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId, String firstName, String lastName, String email){
        log.info("update");
        this.service.updateEmployee(employeeId, firstName, lastName, email);
    }

    @ApiOperation(value = "debug")
    @GetMapping("/employees/name")
    public ResponseEntity<?> getUserByName(){

        return null;
    }
}
