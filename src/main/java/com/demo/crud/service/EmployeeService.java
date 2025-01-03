package com.demo.crud.service;

import com.demo.crud.model.Employee;
import com.demo.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String CreateEmployee(Employee employee){
        //System.out.println(employee.getEmpName());
        try{

            employeeRepository.save(employee);
        }catch (Exception e){
            return "exception: "+e;
        }
    return "employee created successfully";
    }

    public List<Employee> getEmployee(){

        List<Employee> emp;
        try {
           emp= employeeRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return emp;
    }
    public String DeleteEmployee(String id){
        try {
           employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "employee deleted successfully";
    }

    public String UpdateEmployee(String id,Employee employee) {
        try{
            Employee existingEmployee = employeeRepository.findById(id).orElse(null);

            if (existingEmployee == null) {
                return "Employee not found";
            }else{
                existingEmployee.setLocation(employee.getLocation());
                existingEmployee.setSalary(employee.getSalary());
                existingEmployee.setEmpName(employee.getEmpName());
                employeeRepository.save(existingEmployee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "employee updated successfully";
    }
}
