package com.example.kyrgyzpochtasy.dao;

import com.example.kyrgyzpochtasy.model.enams.Department;
import com.example.kyrgyzpochtasy.model.enams.Language;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class EmployeeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private Language language;
}
