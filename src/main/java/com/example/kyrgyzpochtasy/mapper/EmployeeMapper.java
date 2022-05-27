package com.example.kyrgyzpochtasy.mapper;

import com.example.kyrgyzpochtasy.dao.EmployeeRequest;
import com.example.kyrgyzpochtasy.dao.EmployeeResponse;
import com.example.kyrgyzpochtasy.exception.BadRequestException;
import com.example.kyrgyzpochtasy.model.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class EmployeeMapper {

    public Employee create(EmployeeRequest employeeRequest) {

        if (employeeRequest == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        if (employeeRequest.getAge()<=120) {
            employee.setAge(employeeRequest.getAge());
        }else {
            throw new BadRequestException("Age must be less than 120");
        }
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setLanguage(employeeRequest.getLanguage());

        return employee;
    }

    public Employee update(Employee employee, EmployeeRequest employeeRequest) {
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setAge(employeeRequest.getAge());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setLanguage(employeeRequest.getLanguage());

        return employee;
    }

    public EmployeeResponse viewEmployee(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeResponse employeeResponse = new EmployeeResponse();
        if (employee.getId() != null) {
            employeeResponse.setId(employee.getId());
        }
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setAge(employee.getAge());
        employeeResponse.setDepartment(employee.getDepartment());
        employeeResponse.setLanguage(employee.getLanguage());

        return employeeResponse;
    }

    public List<EmployeeResponse> viewEmployees(List<Employee> employees) {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee e : employees) {
            employeeResponses.add(viewEmployee(e));
        }
        return employeeResponses;
    }
}
