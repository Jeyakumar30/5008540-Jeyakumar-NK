package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projections.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> findAllEmployeeProjections();

    @Query("SELECT new com.example.EmployeeManagementSystem.dto.EmployeeDTO(e.id, e.name, e.email, e.department.name) FROM Employee e")
    List<EmployeeDTO> findAllEmployeeDTOs();

    // Find employees by department name using a custom JPQL query
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findByDepartmentNameCustom(@Param("departmentName") String departmentName);

    // Find employees by a specific email domain using a native SQL query
    @Query(value = "SELECT * FROM employees WHERE email LIKE %:domain", nativeQuery = true)
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    // Using the named query to find an employee by email
    @Query(name = "Employee.findByEmailNamed")
    Optional<Employee> findByEmailNamed(@Param("email") String email);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("deptName") String departmentName);
}