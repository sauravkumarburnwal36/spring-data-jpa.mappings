package com.springdatajpa.datamapping.mapping.repositories;

import com.springdatajpa.datamapping.mapping.entities.DepartmentEntity;
import com.springdatajpa.datamapping.mapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
