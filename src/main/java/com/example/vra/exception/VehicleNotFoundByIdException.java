package com.example.vra.exception;

public class VehicleNotFoundByIdException extends RuntimeException{

	private String massage;

	public VehicleNotFoundByIdException(String massage) {
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
