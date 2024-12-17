package com.example.vra.exceptionhandller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vra.errorstructure.ErrorStructure;
import com.example.vra.exception.ProfilePictureNotFoundByIdException;
import com.example.vra.exception.UserNotFoundbyIdException;

@RestControllerAdvice
public class ApplicationExceptionHandller {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> userNotFoundById(UserNotFoundbyIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), e.getMassage(), "user not found by id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleProfilePictureNotFound(ProfilePictureNotFoundByIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				e.getMassage(), "Failed to Find the image"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUsernameNotFoundException(UsernameNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), "Failed to Find the User"));
	}
}
