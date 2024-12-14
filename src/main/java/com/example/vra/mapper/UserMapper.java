package com.example.vra.mapper;

import org.springframework.stereotype.Component;

import com.example.vra.entity.User;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;
@Component
public class UserMapper {

	public User mapToUser(UserRequest request,User user) {
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setPassword(request.getPassword());
		return user;
	}
	
	public UserResponse mapToUserResponse(User user) {
		UserResponse response = new UserResponse();
		
		response.setUserName(user.getUserName());
		response.setUserId(user.getUserId());
		response.setEmail(user.getEmail());
		response.setPhoneNumber(user.getPhoneNumber());
		response.setRole(user.getRole());
		return response;
	}
	
}
