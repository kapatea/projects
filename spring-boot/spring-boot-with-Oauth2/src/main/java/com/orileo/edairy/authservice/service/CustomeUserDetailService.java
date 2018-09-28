/**
 * 
 */
package com.orileo.edairy.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orileo.edairy.authservice.modal.Employee;
import com.orileo.edairy.authservice.repository.EmployeeRepository;

/**
 * @author H Kapil Kumar
 *
 */

@Service
public class CustomeUserDetailService implements UserDetailsService
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Employee> userOptional = employeeRepository.findByEmail(email);
		if(userOptional.isPresent())
		{
			new UsernameNotFoundException("employee dose not exist "+email);
		}else{
			return userOptional.get();
		}
		return null;
		
	}

}
