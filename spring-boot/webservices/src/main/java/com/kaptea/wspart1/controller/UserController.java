package com.kaptea.wspart1.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.CollectionUtils;
import com.kaptea.wspart1.entity.User;
import com.kaptea.wspart1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * @param user
	 * @return create new user and return the created user
	 */
	@PostMapping
	public ResponseEntity<User> createNewUser(@Valid @RequestBody User user){
	
		User persistedUser = userService.createNewUser(user);
		return new ResponseEntity<>(persistedUser, HttpStatus.CREATED);
	}
	
	/**
	 * lets see simple exceptions handling here
	 * @return all saved users 
	 */
	@GetMapping
	public ResponseEntity<List<User>> getUsers()
	{
		List<User> users = userService.getAllUsers();
		if(CollectionUtils.isEmpty(users)){
			throw new EntityNotFoundException();
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return user by passing user id
	 */
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id){
		User user = userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/**
	 * Update user object 
	 * Note at the time of creating new user we dont pass id so hibernate create 
	 * the new entry in database. But now we are passing the id in user entity 
	 * object so hibernate automatically treate it as update entry lets se
	 * @param user
	 * @return
	 */
	@PutMapping
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		
		User persistedUser = userService.createNewUser(user);
		return new ResponseEntity<>(persistedUser, HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<User> deleteUser(@PathVariable long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}