package com.ichiroo.cruddemo;

import com.ichiroo.cruddemo.dao.StudentDAO;
import com.ichiroo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Delete add students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete rows count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=5;
		System.out.println("Deleting the student: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId =4;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Update student: "+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get a list of student
		List<Student> theStudents = studentDAO.finfByLastName("Do");
		//display list of student
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a List of students
		List<Student> theStudents = studentDAO.findAll();

		//display a list of the students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Create new student: ");
		Student tempStudent = new Student("Due", "Do", "doedo@uu.com");

		//save the student
		System.out.println("Saving the student: ");
		studentDAO.save(tempStudent);

		//display if of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved the student. Generate the id: "+theId);

		//retrieved student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		//display the student
		System.out.println("Found the student: "+myStudent);
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
