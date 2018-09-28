package com.orileo.edairy.authservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orileo.edairy.authservice.modal.Student;
import com.orileo.edairy.authservice.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	private StudentRepository studentRepository;

	StudentServiceImpl(StudentRepository studentRepository)
	{
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student saveStdeunt(Student employee) {
		return studentRepository.save(employee);
	}

	@Override
	public List<Student> listOfStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(long id) {
		return studentRepository.findOne(id);
	}

	@Override
	public void dropStudent(long id) {
		studentRepository.delete(id);
	}
}
