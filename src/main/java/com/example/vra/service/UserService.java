package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
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

	public UserService(UserRepository userRepository,ImageRepository imageRepository,UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.imageRepository=imageRepository;
		this.userMapper=userMapper;
	}

	public UserResponse addUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		User user = userMapper.mapToUser(userRequest);
		User user2 = userRepository.save(user);
		return userMapper.mapToUserResponse(user2);
	}

	public void uploadProfile(int userId, MultipartFile file) {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			Image image = imageRepository.save(this.getImage(file));
			
			User user = optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);
		}else {
			throw new UserNotFoundbyIdException("user not for the given Id");
		}
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
	
}
