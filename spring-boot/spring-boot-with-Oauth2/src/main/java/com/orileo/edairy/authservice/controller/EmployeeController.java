package com.orileo.edairy.authservice.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.orileo.edairy.authservice.modal.Employee;
import com.orileo.edairy.authservice.service.EmployeeService;

@RestController
public class EmployeeController extends BaseController
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value="/employee" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	private Employee saveEmployee(@RequestBody Employee employee)
	{
		employee.setPassword("1234");
		employee.setLastPasswordResetDate(new Timestamp(new Date().getTime()));

		Employee employeePersisted = employeeService.saveEmployee(employee);
		return employeePersisted;
	}
	
	@PreAuthorize ("hasRole('ADMIN')")
	@GetMapping(value="/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Employee> getListEmployess(){
		System.out.println("Employee Get Call");
		return employeeService.listOfEmployees();
	}
	
	@GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Employee getEmployee(@PathVariable("id") long id){
		Employee employee = employeeService.getEmployee(id);
		return employee;
	}
	
	@PutMapping(value="/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
	private Employee updateEmployee(@RequestBody Employee employee){
		Employee persistedEmployee = employeeService.saveEmployee(employee);
		return persistedEmployee;
	}
	
	@DeleteMapping(value="/employee/{id}")
	private void dropEmployee(@PathVariable("id") long id){
		employeeService.dropEmployee(id);;
	}
}