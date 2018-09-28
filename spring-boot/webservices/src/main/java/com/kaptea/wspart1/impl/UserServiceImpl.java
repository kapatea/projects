package com.kaptea.wspart1.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaptea.wspart1.entity.User;
import com.kaptea.wspart1.repository.UserRepository;
import com.kaptea.wspart1.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User createNewUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(long id) {
		return userRepository.getOne(id);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}
}