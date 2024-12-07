package com.springdatajpa.datamapping.mapping.services;

import com.springdatajpa.datamapping.mapping.entities.EmployeeEntity;
import com.springdatajpa.datamapping.mapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public EmployeeEntity getEmployeeById(Long employeeId){
        return  employeeRepository.findById(employeeId).orElse(null);
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);
    }

}
