package com.lenapalasionak.spring.mvc.controller;

import com.lenapalasionak.spring.mvc.dao.EmployeeDAO;
import com.lenapalasionak.spring.mvc.entity.Employee;
import com.lenapalasionak.spring.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;//Объект нужен, чтобы достать метод getAllEmployees().
    // Пишем тип интерфейса, а этот интерфейс имплеметируется только одним классом

    @RequestMapping("/")//список всех работников будет выходить по слешу
    public String showAllEmployees(Model model) {

       List<Employee> allEmployees = employeeService.getAllEmployees();
       model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }
    @RequestMapping("/addNewEmployee")
        public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {//получили из формы работника с заполненными данными

        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

}
