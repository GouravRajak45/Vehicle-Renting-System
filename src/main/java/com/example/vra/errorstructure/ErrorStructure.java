package com.example.vra.errorstructure;

public class ErrorStructure {

	private int status;
	private String massage;
	private String rootCouse;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getRootCouse() {
		return rootCouse;
	}
	public void setRootCouse(String rootCouse) {
		this.rootCouse = rootCouse;
	}
	
	public static ErrorStructure create(int status,String massage,String rootCouse) {
		ErrorStructure error = new ErrorStructure();
		error.setStatus(status);
		error.setMassage(massage);
		error.setRootCouse(rootCouse);
		return error;
	}
}
