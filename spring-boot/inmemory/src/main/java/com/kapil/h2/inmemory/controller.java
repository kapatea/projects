package com.kapil.h2.inmemory;

import com.kapil.h2.inmemory.domain.Employee;
import com.kapil.h2.inmemory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther H Kapil Kumar on 13/3/18.
 */
@RestController
public class controller
{
    @Autowired
    private EmployeeService employeeService;

    // give list of employees in json
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> employees(){
        List<Employee> employees = employeeService.getEmployess();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
