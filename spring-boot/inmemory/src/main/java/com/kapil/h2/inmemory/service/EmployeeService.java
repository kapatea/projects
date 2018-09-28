package com.kapil.h2.inmemory.service;

import com.kapil.h2.inmemory.domain.Employee;

import java.util.List;

/**
 * @Auther H Kapil Kumar on 13/3/18.
 */
public interface EmployeeService
{
    public List<Employee> getEmployess(); // to fetch all the employees from database
}