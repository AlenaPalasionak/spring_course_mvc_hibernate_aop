package com.lenapalasionak.spring.mvc.controller;

import com.lenapalasionak.spring.mvc.dao.EmployeeDAO;
import com.lenapalasionak.spring.mvc.entity.Employee;
import com.lenapalasionak.spring.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;//Объект нужен, чтобы достать метод getAllEmployees().
    // Пишем тип интерфейса, а этот интерфейс имплеметируется только одним классом

    @RequestMapping("/")//список всех работников будет выходить по слешу
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();//достаем из бд всех работников
        model.addAttribute("allEmps", allEmployees);//добавляем атрибут в модель, а именно список раб-ов

        return "all-employees";//список работников
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();// форма будет пустой, т.к. создаем нового работника
        model.addAttribute("employee", employee);

        return "employee-info";//форма для заполнения
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {//получили из формы работника с заполненными данными
        //@ModelAttribute — это аннотация, которая связывает параметр метода с названным атрибутом модели, а затем предоставляет его веб-представлению.

        employeeService.saveEmployee(employee);
        return "redirect:/";//список работников
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {// получили id работника из формы
        //и дальше передадим его в метод сервиса(дальше он пойдет в дао и принесет нам работника
        // из базы данных с нужным id
        Employee employee = employeeService.getEmployee(id);//берем работника из базы
        model.addAttribute("employee", employee);//передаем не пустого работника, а работника из базы, для редакции
        return "employee-info";//форма для заполнения
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {

        Employee employee = employeeService.getEmployee(id);//берем работника из базы по id
        employeeService.deleteEmployee(id);

        return "redirect:/";//список работников

    }

}
