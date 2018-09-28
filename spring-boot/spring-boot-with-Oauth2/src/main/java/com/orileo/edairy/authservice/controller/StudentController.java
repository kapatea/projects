package com.orileo.edairy.authservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.orileo.edairy.authservice.modal.Student;
import com.orileo.edairy.authservice.service.StudentService;

@RestController
public class StudentController extends BaseController
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value="/student" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	private Student saveStudent(@RequestBody Student student)
	{
		Student studentPersisted = studentService.saveStdeunt(student);
		return studentPersisted;
	}
	
	@GetMapping(value="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Student> getListStudents(){
		System.out.println("Hey");
		return studentService.listOfStudents();
	}
	
	@GetMapping(value="/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Student getStudent(@PathVariable("id") long id){
		Student student = studentService.getStudent(id);
		return student;
	}
	
	@PutMapping(value="/student", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Student updateStudent(@RequestBody Student student){
		Student persistedStudent = studentService.saveStdeunt(student);
		return persistedStudent;
	}
	
	@DeleteMapping(value="/student/{id}")
	private void dropStudent(@PathVariable("id") long id){
		studentService.dropStudent(id);
	}
}