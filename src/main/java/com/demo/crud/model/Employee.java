package com.demo.crud.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String empName;
    private String location;

    public Employee(String id, String empName, String location, BigDecimal salary) {
        this.id = id;
        this.empName = empName;
        this.location = location;
        this.salary = salary;
    }

    public Employee() {
    }

    private BigDecimal salary;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", empName='" + empName + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                '}';
    }
}
