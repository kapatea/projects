package com.orileo.edairy.authservice.service;

import java.util.List;
import java.util.Optional;

import com.orileo.edairy.authservice.modal.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> listOfEmployees();
	
	public Employee getEmployee(long id);
	
	public void dropEmployee(long id);
	
	Optional<Employee>  findByEmail(String email);
}