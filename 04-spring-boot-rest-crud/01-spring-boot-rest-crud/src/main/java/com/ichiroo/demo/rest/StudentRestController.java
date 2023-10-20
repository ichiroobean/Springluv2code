package com.ichiroo.demo.rest;

import com.ichiroo.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the students data...only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("s","d"));
        theStudents.add(new Student("ghi","dhi"));
        theStudents.add(new Student("shu","dhy"));
    }

    //define end point for "/student" -return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    //define endpoint or "/students/{studentId}" return student index
    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list ... keep it simple for now

        //check the studentID size again in list
        if (studentId>=theStudents.size()||studentId<0){
            throw new StudentNotFoundException("Student is not found "+studentId);
        }
        return theStudents.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handlerException(StudentNotFoundException exc){
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler  ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handlerException(Exception e){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
