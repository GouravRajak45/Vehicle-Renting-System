package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.responsestructure.ImageResponseStructure;
import com.example.vra.responsestructure.ResponseStructure;
import com.example.vra.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		User user1 = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Ragisterd", user1));
	}
	
	@PostMapping("/uploade-user-profile")
	public ResponseEntity<ImageResponseStructure> uploadUserProfile(@RequestParam ("userId")int userId,@RequestParam ("file")MultipartFile file) {
		userService.uploadProfile(userId,file);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ImageResponseStructure.create(HttpStatus.CREATED.value(), "Image uploaded"));
	}
	
	@GetMapping("/fetch-Image")
	public ResponseEntity<byte[]> fetchImageById(@RequestParam ("imageId")int imageId){
		Image image = userService.fetchImageById(imageId);
		
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.valueOf(image.getContentType()))
				.body(image.getImageBytes());
	}
}
