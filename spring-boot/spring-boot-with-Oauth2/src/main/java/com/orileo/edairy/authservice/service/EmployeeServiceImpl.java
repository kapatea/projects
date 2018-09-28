package com.orileo.edairy.authservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.orileo.edairy.authservice.modal.Employee;
import com.orileo.edairy.authservice.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService
{
	
	private EmployeeRepository employeeRepository;
	
	EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> listOfEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public void dropEmployee(long id) {
		employeeRepository.delete(id);
	}

	@Override
	public Optional<Employee> findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
}