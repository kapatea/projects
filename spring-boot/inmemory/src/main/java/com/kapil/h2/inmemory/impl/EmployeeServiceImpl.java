package com.kapil.h2.inmemory.impl;

import com.kapil.h2.inmemory.domain.Employee;
import com.kapil.h2.inmemory.repository.EmployeeRepository;
import com.kapil.h2.inmemory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther H Kapil Kumar on 13/3/18.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployess() {
        return employeeRepository.findAll();
    }
}
