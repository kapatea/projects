package com.kaptea.wspart1.service;

import java.util.List;

import com.kaptea.wspart1.entity.User;

public interface UserService {

	User createNewUser(User user);
	List<User> getAllUsers();
	
	User getUser(long id);
	
	void deleteUser(long id);
}