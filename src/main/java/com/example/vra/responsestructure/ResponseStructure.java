package com.example.vra.responsestructure;

public class ResponseStructure<T> {

	private int status;
	private String massage;
	private T data;
	
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public static <T>ResponseStructure<T> create(int status,String massage,T data){
		ResponseStructure<T> response = new ResponseStructure<T>();
		response.setStatus(status);
		response.setMassage(massage);
		response.setData(data);
		return response;
	}
	
}
