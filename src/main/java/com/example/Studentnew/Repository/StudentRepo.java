package com.example.Studentnew.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Studentnew.Model.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
