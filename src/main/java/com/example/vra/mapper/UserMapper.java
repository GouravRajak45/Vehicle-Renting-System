package com.example.vra.mapper;

import org.springframework.stereotype.Component;

import com.example.vra.entity.User;
import com.example.vra.enums.Role;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;
@Component
public class UserMapper {

	public User mapToUser(UserRequest request,Role role) {
		User user = new User();
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(role);
		return user;
	}
	
	public User mapToRentingPartner(UserRequest request,Role role) {
		User user = new User();
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(role);
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