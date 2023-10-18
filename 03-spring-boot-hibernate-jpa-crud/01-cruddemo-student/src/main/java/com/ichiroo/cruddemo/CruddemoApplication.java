package com.ichiroo.cruddemo;

import com.ichiroo.cruddemo.dao.StudentDAO;
import com.ichiroo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMutipleStudents(studentDAO);
		};
	}

	private void createMutipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("John","Doe","john@gmail.com");
		Student tempStudent2 = new Student("Meo","Dup","meo@gmail.com");
		Student tempStudent3 = new Student("Gow","Gut","gow@gmail.com");

		//save the students objects
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");

		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved the student, generated student id: "+ tempStudent.getId());
	}
}
