package com.lenapalasionak.spring.mvc.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;

    @Column(name="name")
    String name;

    @Column(name="surname")
    String surname;

    @Column(name="department")
    String department;

    @Column(name="salary")
    int salary;

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
