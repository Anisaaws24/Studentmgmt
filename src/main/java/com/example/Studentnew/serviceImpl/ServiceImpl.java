package com.example.Studentnew.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Studentnew.Model.Student;
import com.example.Studentnew.Repository.StudentRepo;
import com.example.Studentnew.service.Studservice;

import com.example.Studentnew.Exception.ResourceNotFoundException;



@Service
public class ServiceImpl implements Studservice{
	
@Autowired	
	private StudentRepo repo;


	public ServiceImpl(StudentRepo repo) {
	super();
	this.repo = repo;
}

	@Override
	public Student saveStudent(Student stud) {
		// TODO Auto-generated method stub
		return repo.save(stud);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteStudent(String rparam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> insertAllStudent(List<Student> s) {
		// TODO Auto-generated method stub
		return repo.saveAll(s);
	}

	
	
	

	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		
		
		Optional<Student> stud=repo.findById(id);
		if(stud.isPresent())
		{
			return stud.get();
		}
		else
		{
			throw new ResourceNotFoundException("Student","Id",id);
		}
	}
	@Override
	public void deleteStudent(long id) {
		//TODO Auto-generated method stub
	repo.findById(id).orElseThrow(()
			-> new ResourceNotFoundException("Student","Id",id));
		repo.deleteById(id);
		
	}

	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		Student existingStudent=repo.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Student","Id",id));
		
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		return repo.save(existingStudent);
		
	}

	

	
	
	

	

}
