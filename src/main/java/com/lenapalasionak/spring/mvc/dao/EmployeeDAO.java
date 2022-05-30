package com.lenapalasionak.spring.mvc.dao;

import com.lenapalasionak.spring.mvc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
}
