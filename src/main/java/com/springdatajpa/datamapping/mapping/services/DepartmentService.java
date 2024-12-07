package com.springdatajpa.datamapping.mapping.services;

import com.springdatajpa.datamapping.mapping.entities.DepartmentEntity;
import com.springdatajpa.datamapping.mapping.entities.EmployeeEntity;
import com.springdatajpa.datamapping.mapping.repositories.DepartmentRepository;
import com.springdatajpa.datamapping.mapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository,EmployeeRepository employeeRepository){
        this.departmentRepository=departmentRepository;
        this.employeeRepository=employeeRepository;
    }

    public DepartmentEntity getDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
       Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
       Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);

       return departmentEntity.flatMap(department->
               employeeEntity.map(employee->{
                   department.setManager(employee);
                   return departmentRepository.save(department);
               })).orElse(null);
    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {
//            Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
//            return employeeEntity.map(employee->employee.getManagedDepartment()).orElse(null);

        EmployeeEntity employeeEntity=EmployeeEntity.builder().id(employeeId).build();
        return departmentRepository.findByManager(employeeEntity);
        }
}
