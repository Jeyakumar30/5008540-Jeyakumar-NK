package com.example.EmployeeManagementSystem.repository.secondary;

import com.example.EmployeeManagementSystem.entity.SecondaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> {
}