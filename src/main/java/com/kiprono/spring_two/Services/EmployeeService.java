package com.kiprono.spring_two.Services;

import com.kiprono.spring_two.entities.Employee;
import com.kiprono.spring_two.exceptions.EmailTakenException;
import com.kiprono.spring_two.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) throws EmailTakenException {
//        this.employeeRepository.save(employee);
        Optional<Employee> findbyEmail = this.employeeRepository.findEmployeeByEmail(employee.getEmail());

        if(findbyEmail.isPresent()){
            throw  new EmailTakenException("Email taken");
        } else {
            this.employeeRepository.save(employee);
        }

        System.out.println(employee);
    }

    public void deleteEmployee(Long id) {
        if(this.employeeRepository.existsById(id)){
            this.employeeRepository.deleteById(id);
        } else{
            throw new IllegalStateException("Employee with id " + id + " does not exist");
        }
    }


    @Transactional
    public void updateEmployee(Long employeeId, String firstName, String lastName, String email) {
        System.out.println("{ " + employeeId + " " + firstName + " " + lastName + email + " }");
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(
                () -> new IllegalStateException("Employee with id " + employeeId + " was not found")
        );

        System.out.println(employee);

        // check if names are null
        if((firstName != null) &&  (firstName.length() > 0) && (! employee.getFirstName().equals(firstName))){
            employee.setFirstName(firstName);
        }

        if((lastName != null) &&  (lastName.length() > 0) && (! employee.getLastName().equals(lastName))){
            employee.setLastName(lastName);
        }

        // check email
        if((email != null) && (! employee.getEmail().equals(email))){

            // check if supplied email has been taken
            if(this.employeeRepository.findEmployeeByEmail(email).isPresent()){
                throw new EmailTakenException("Yikes, this Email has already been taken");
            }else{
                employee.setEmail(email);
            }
        }

    }
}
