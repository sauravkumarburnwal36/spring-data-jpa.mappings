package com.springdatajpa.datamapping.mapping.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "departments")
public class DepartmentEntity {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    @Column(nullable = false)
    private String title;

    @JsonProperty("manager")
    @OneToOne
    @JoinColumn(name ="department_manager")
    private EmployeeEntity manager;

    public void setManager(EmployeeEntity manager){
        this.manager = manager;
    }

  
}
