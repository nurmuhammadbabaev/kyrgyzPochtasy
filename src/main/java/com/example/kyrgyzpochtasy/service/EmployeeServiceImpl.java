package com.example.kyrgyzpochtasy.service;

import com.example.kyrgyzpochtasy.dao.EmployeeRequest;
import com.example.kyrgyzpochtasy.dao.EmployeeResponse;
import com.example.kyrgyzpochtasy.exception.BadRequestException;
import com.example.kyrgyzpochtasy.mapper.EmployeeMapper;
import com.example.kyrgyzpochtasy.model.entity.Employee;
import com.example.kyrgyzpochtasy.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeResponse create(EmployeeRequest employeeRequest) {
        return mapper.viewEmployee(repository.save(mapper.create(employeeRequest)));
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        Employee employee = getByIdMethod(id);
        mapper.update(employee, employeeRequest);
        return mapper.viewEmployee(repository.save(employee));
    }

    @Override
    public EmployeeResponse deleteById(Long id) {
        Employee employee = getByIdMethod(id);
        repository.delete(employee);
        return mapper.viewEmployee(employee);
    }

    @Override
    public EmployeeResponse getById(Long id) {
        return mapper.viewEmployee(getByIdMethod(id));
    }

    @Override
    public List<EmployeeResponse> getAll() {
        return mapper.viewEmployees(repository.findAll());
    }

    private Employee getByIdMethod(Long id) {
        return repository.findById(id).
                orElseThrow(() -> {
                    log.error("Employee with id = {} does not exists", id);
                    throw new BadRequestException(
                            String.format("Employee with id = %s does not exists", id)
                    );
                });
    }
}
