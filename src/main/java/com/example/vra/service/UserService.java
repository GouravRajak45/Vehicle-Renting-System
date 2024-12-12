package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.exception.FailedToUploadException;
import com.example.vra.exception.UserNotFoundbyIdException;
import com.example.vra.repository.ImageRepository;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final ImageRepository imageRepository;

	public UserService(UserRepository userRepository,ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository=imageRepository;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
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
	
}
