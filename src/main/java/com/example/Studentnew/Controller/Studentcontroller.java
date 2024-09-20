package com.example.Studentnew.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Studentnew.Model.Student;
import com.example.Studentnew.service.Studservice;



@RestController
@RequestMapping("/api/student")
public class Studentcontroller {
	
	private Studservice service;

	public Studentcontroller(Studservice service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/app")
	public ResponseEntity<Student> saveStudent(@RequestBody Student stud)
	{
		
		return new ResponseEntity<Student>(service.saveStudent(stud),HttpStatus.CREATED);
		
		
	}
	@GetMapping	
	public List<Student> getAllStudents()
	{
		
		return service.getAllStudent();
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) 
		{
			
		
			return new ResponseEntity<Student>(service.getStudentById(id),HttpStatus.OK);
		}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id")long id,@RequestBody Student stud)
	{
		return new ResponseEntity<Student>(service.updateStudent(stud, id),HttpStatus.OK);
	}

	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id")long id)

	{
		service.deleteStudent(id);
	    return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
	}
}
