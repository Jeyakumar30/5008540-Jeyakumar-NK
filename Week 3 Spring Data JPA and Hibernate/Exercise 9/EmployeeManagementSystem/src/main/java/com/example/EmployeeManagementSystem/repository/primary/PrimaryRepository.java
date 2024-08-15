package com.example.EmployeeManagementSystem.repository.primary;

import com.example.EmployeeManagementSystem.entity.PrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> {
}