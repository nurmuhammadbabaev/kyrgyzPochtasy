package com.example.kyrgyzpochtasy.repository;

import com.example.kyrgyzpochtasy.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
