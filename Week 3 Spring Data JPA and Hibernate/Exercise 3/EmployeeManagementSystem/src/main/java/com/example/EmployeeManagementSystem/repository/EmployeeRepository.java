package com.example.EmployeeManagementSystem.repository;


import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query methods
    List<Employee> findByName(String name);

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByEmailContaining(String keyword);
}
