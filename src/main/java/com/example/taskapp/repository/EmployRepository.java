package com.example.taskapp.repository;

import com.example.taskapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employee, Long> {
}
