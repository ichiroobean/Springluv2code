package com.ichiroo.springboot.cruddemo.dao;

import com.ichiroo.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee>findAll();
}
