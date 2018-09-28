/**
 * 
 */
package com.orileo.edairy.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orileo.edairy.authservice.modal.Employee;

/**
 * @author H Kapil Kumar
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
	public Optional<Employee> findByEmail(String email);
}
