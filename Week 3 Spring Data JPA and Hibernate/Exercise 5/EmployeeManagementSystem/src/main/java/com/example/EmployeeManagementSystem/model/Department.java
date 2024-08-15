package com.example.EmployeeManagementSystem.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Setter
@Getter
@Entity
@Table(name = "departments")
@NamedQueries({
        @NamedQuery(name = "Department.findByNameNamed", query = "SELECT d FROM Department d WHERE d.name = :name")
})
public class Department {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}