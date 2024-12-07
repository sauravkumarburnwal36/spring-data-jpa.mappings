package com.springdatajpa.datamapping.mapping.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="employees")
public class EmployeeEntity {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy ="manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    public DepartmentEntity getManagedDepartment(){
        return managedDepartment;
    }

}
