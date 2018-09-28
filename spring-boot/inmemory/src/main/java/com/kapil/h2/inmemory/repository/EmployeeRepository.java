package com.kapil.h2.inmemory.repository;

import com.kapil.h2.inmemory.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther H Kapil Kumar on 13/3/18.
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
