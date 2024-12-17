package com.example.vra.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.enums.Role;
import com.example.vra.exception.FailedToUploadException;
import com.example.vra.exception.ProfilePictureNotFoundByIdException;
import com.example.vra.exception.UserNotFoundbyIdException;
import com.example.vra.mapper.UserMapper;
import com.example.vra.repository.ImageRepository;
import com.example.vra.repository.UserRepository;
import com.example.vra.requestdto.UserRequest;
import com.example.vra.responsedto.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ImageRepository imageRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository,ImageRepository imageRepository,UserMapper userMapper,PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.imageRepository=imageRepository;
		this.userMapper=userMapper;
		this.passwordEncoder=passwordEncoder;
	}

	public UserResponse addUser(UserRequest userRequest,Role role) {
		User user = userMapper.mapToUser(userRequest,role);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);
		User user2 = userRepository.save(user);
		return userMapper.mapToUserResponse(user2);
	}

	public void uploadProfile(int userId, MultipartFile file) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			User user = optional.get();
			
			if(user.getProfilePicture()!=null) {
				Image image = user.getProfilePicture();
				this.uploadUserProfile(file,user);
				imageRepository.delete(image);
			}
			this.uploadUserProfile(file,user);
		}else {
			throw new UserNotFoundbyIdException("user not for the given Id");
		}
	}
	
	private void uploadUserProfile(MultipartFile file, User user) {
		Image image = imageRepository.save(this.getImage(file));

		user.setProfilePicture(image);
		userRepository.save(user);
		
	}

	private Image getImage(MultipartFile file) {
		Image image = new Image();
		try {
			byte[] imageBytes = file.getBytes();
			
			image.setContentType(file.getContentType());
			image.setImageBytes(imageBytes);
			imageRepository.save(image);
		}catch (Exception e) {
			throw new FailedToUploadException("user failed to uploade image");
		}
		return image;
	}

	public Image fetchImageById(int imageId) {
		Optional<Image> optional = imageRepository.findById(imageId);
		if(optional.isPresent()) {
			Image image = optional.get();
			return image;
		}else {
			throw new ProfilePictureNotFoundByIdException("image not found");
		}
	}

	public UserResponse fetchUserById(int userId) {
		
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			User user = optional.get();
			
			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, user.getUserId());
			return response;
		}else {
			throw new UserNotFoundbyIdException("User not found");
		}
	}
	
	private void setProfilePictureURL(UserResponse response,int userId) {
		int imageId = userRepository.getProfilePictureByUserId(userId);
		if(imageId>0) {
			response.setProfilePicture("/fetch-Image?imageId="+imageId);
		}
	}

	public UserResponse addRentingPartner(UserRequest userRequest, Role rentingPartner) {
		User user = userMapper.mapToRentingPartner(userRequest, rentingPartner);
		User user2 = userRepository.save(user);
		return userMapper.mapToUserResponse(user2);
	}
	
	public UserResponse updateUserById(UserRequest userRequest,int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			User user = userMapper.mapWithUser(userRequest,optional.get());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			
			UserResponse response = userMapper.mapToUserResponse(user);
			this.setProfilePictureURL(response, userId);
			return response;
		}else {
			throw new UserNotFoundbyIdException("Failed to Find User");
		}
		
	}
	
	
}
