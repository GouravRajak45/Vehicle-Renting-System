package com.example.vra.exception;

public class UserNotFoundbyIdException extends RuntimeException{

	private String massage;

	public UserNotFoundbyIdException(String massage) {
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
