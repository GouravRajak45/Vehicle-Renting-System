package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
	
	
}
