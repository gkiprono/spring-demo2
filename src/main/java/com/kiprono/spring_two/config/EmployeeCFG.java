package com.kiprono.spring_two.config;

import com.kiprono.spring_two.entities.Employee;
import com.kiprono.spring_two.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeCFG {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            Employee tundra = new Employee( "Toyota", "Tundra", "tundra@toyota.com");
            Employee camry = new Employee( "Toyota", "Camry", "camry@toyota.com");
            Employee corolla = new Employee( "Toyota", "Corolla", "corolla@toyota.com");
            Employee sienna = new Employee( "Toyota", "Sienna", "sienna@toyota.com");

            employeeRepository.saveAll(List.of(tundra, camry,corolla, sienna));
        };
    }
}
