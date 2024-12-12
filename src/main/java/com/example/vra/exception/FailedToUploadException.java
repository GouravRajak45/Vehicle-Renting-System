package com.example.vra.exception;

public class FailedToUploadException extends RuntimeException{

	private String massage;

	public FailedToUploadException(String massage) {
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
