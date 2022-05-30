package com.lenapalasionak.spring.mvc.controller;

import com.lenapalasionak.spring.mvc.dao.EmployeeDAO;
import com.lenapalasionak.spring.mvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeDAO employeeDAO;//Объект нужен, чтобы достать метод getAllEmployees().
    // Пишем тип интерфейса, а этот интерфейс имплеметируется только одним классом

    @RequestMapping("/")//список всех работников будет выходить по слешу
    public String showAllEmployees(Model model) {

       List<Employee> allEmployees = employeeDAO.getAllEmployees();
       model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }
}
