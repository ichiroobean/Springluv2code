package com.ichiroo.springboot.cruddemo.rest;

import com.ichiroo.springboot.cruddemo.dao.EmployeeDAO;
import com.ichiroo.springboot.cruddemo.entity.Employee;
import com.ichiroo.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    //quick and dirty: inject employee dao (use constructor injection)
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    //expose "/employee" and return a list of employee
    @GetMapping("/employee")
    public List<Employee>finAll(){
        return employeeService.findAll();
    }

    //add mapping for GET/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw  new RuntimeException("");
        }
    }
}
