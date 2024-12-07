package com.springdatajpa.datamapping.mapping.controllers;
import com.springdatajpa.datamapping.mapping.services.EmployeeService;
import com.springdatajpa.datamapping.mapping.entities.EmployeeEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.createNewEmployee(employeeEntity);
    }
}
