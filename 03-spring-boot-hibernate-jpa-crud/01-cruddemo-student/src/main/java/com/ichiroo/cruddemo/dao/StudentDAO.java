package com.ichiroo.cruddemo.dao;

import com.ichiroo.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> finfByLastName(String theLastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
