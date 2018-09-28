package com.orileo.edairy.authservice.service;

import java.util.List;
import com.orileo.edairy.authservice.modal.Student;

public interface StudentService {

	public Student saveStdeunt(Student employee);
	
	public List<Student> listOfStudents();
	
	public Student getStudent(long id);
	
	public void dropStudent(long id);
}