package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class StudentDAO {

	@Autowired
	StudentRepo repo;
	public void addStudent(Student student)
	{
		repo.save(student);
	}
	public List<Student>viewall()
	{
		return repo.findAll();
	}
	
	public Student findStudent(String email)
	{
		return repo.findByEmail(email);
	}
	public void delete(String email)
	{
		repo.delete(findStudent(email));
	}
	public void update(Student student) {
		repo.delete(student);
		repo.save(student);
	}
	 public void updateStudent(String email, Student updatedStudent) {
	        // Find the existing student by email
	        Student existingStudent = repo.findByEmail(email);

	        if (existingStudent != null) {
	          
	            existingStudent.setFirstname(updatedStudent.getFirstname());
	            existingStudent.setAge(updatedStudent.getAge());
	            existingStudent.setAddress(updatedStudent.getAddress());
	          
	            repo.save(existingStudent);
	        } else {
	            throw new RuntimeException("Student with email " + email + " not found.");
	        }
	    }
}
