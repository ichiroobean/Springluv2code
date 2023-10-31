package com.ichiroo.springboot.cruddemo.dao;

import com.ichiroo.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //set up constructor injection
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee>theQuery=entityManager.createQuery("from Employee ", Employee.class);

        //execute query and get result list
        List<Employee>employees=theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save  the dbEmployee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find the employee by ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove employee
        entityManager.remove(theEmployee);
    }
}
