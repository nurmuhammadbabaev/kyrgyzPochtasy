package com.example.kyrgyzpochtasy.controller;


import com.example.kyrgyzpochtasy.dao.EmployeeRequest;
import com.example.kyrgyzpochtasy.dao.EmployeeResponse;
import com.example.kyrgyzpochtasy.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/save")
   public EmployeeResponse create(@RequestBody EmployeeRequest employeeRequest){
     return  service.create(employeeRequest);
   }
   @PutMapping("/update/{id}")
   public EmployeeResponse update(@PathVariable Long id,@RequestBody EmployeeRequest employeeRequest){
       return service.update(id, employeeRequest);
   }
   @DeleteMapping("/delete/{id}")
   public EmployeeResponse deleteById(@PathVariable Long id){
       return service.deleteById(id);
   }
   @GetMapping("/get/{id}")
   public EmployeeResponse getById(@PathVariable Long id){
       return service.getById(id);
   }
   @GetMapping("/all")
   public List<EmployeeResponse> getAll(){
       return service.getAll();
   }
}
