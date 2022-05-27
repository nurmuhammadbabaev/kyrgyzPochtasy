package com.example.kyrgyzpochtasy.service;

import com.example.kyrgyzpochtasy.dao.EmployeeRequest;
import com.example.kyrgyzpochtasy.dao.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest employeeRequest);
    EmployeeResponse update(Long id,EmployeeRequest employeeRequest);
    EmployeeResponse deleteById(Long id);
    EmployeeResponse getById(Long id);
    List<EmployeeResponse> getAll();
}
