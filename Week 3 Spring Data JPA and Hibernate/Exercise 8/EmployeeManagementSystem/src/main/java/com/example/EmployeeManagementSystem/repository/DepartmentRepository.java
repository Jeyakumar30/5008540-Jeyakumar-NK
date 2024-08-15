package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.dto.DepartmentDTO;
import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.projections.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<DepartmentProjection> findAllBy();

    @Query("SELECT new com.example.EmployeeManagementSystem.dto.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();

    Optional<Department> findByName(String name);

    // Find departments with a minimum number of employees
    @Query("SELECT d FROM Department d WHERE size(d.employees) >= :minSize")
    List<Department> findDepartmentsWithMinEmployees(@Param("minSize") int minSize);

    // Using the named query to find a department by name
    @Query(name = "Department.findByNameNamed")
    Optional<Department> findByNameNamed(@Param("name") String name);
}
