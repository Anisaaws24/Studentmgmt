package com.example.Studentnew.service;

import java.util.List;

import com.example.Studentnew.Model.Student;

public interface Studservice {
	
	Student saveStudent(Student stud);
	
	List<Student>getAllStudent();
	
	
	String deleteStudent(String rparam);
	
	List<Student>insertAllStudent(List <Student> s);
	
	Student updateStudent(Student student, long id);
	
	
	Student getStudentById(long id);

	void deleteStudent(long id);

	

	

	
	

	 
	
	
	
	

	
	

}
