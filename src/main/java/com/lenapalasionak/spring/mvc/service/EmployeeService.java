package com.lenapalasionak.spring.mvc.service;

import com.lenapalasionak.spring.mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);
}
