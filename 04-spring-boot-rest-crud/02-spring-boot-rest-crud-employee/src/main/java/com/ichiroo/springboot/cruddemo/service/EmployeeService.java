package com.ichiroo.springboot.cruddemo.service;

import com.ichiroo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>findAll();
}
