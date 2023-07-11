package com.example.reactvitespring.repository;

import com.example.reactvitespring.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
