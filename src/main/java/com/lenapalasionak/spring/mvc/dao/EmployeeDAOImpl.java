package com.lenapalasionak.spring.mvc.dao;

import com.lenapalasionak.spring.mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

   @Autowired// в xml файле был создан бин этого класса, тут мы его внедряем в класс EmployeeDAOImpl
    private SessionFactory sessionFactory;

    @Override
    @Transactional//будет автоматом открывать и закрывать транзакции
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        Query <Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        // List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList(); то же самое в одну строчку
        return allEmployees;
    }
}
