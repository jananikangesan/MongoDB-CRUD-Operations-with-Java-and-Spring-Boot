package com.demo.crud.controller;

import com.demo.crud.model.Employee;
import com.demo.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String CreateEmployee(@RequestBody Employee employee){
        System.out.println(employee.toString());
            return employeeService.CreateEmployee(employee);
    }

    @GetMapping("/getEmployee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String DeleteEmployee(@RequestParam String id){
        return employeeService.DeleteEmployee(id);
    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String UpdateEmployee(@PathVariable String id,@RequestBody Employee employee){
        return employeeService.UpdateEmployee(id,employee);
    }

}
