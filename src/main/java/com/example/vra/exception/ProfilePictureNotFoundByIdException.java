package com.example.vra.exception;

public class ProfilePictureNotFoundByIdException extends RuntimeException{

	private String massage;

	public ProfilePictureNotFoundByIdException(String massage) {
		super();
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}
	
	
}
