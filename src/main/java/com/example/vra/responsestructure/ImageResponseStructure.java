package com.example.vra.responsestructure;

public class ImageResponseStructure {

	private int status;
	private String massage;
	
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
	
	public static ImageResponseStructure create(int status,String massage) {
		ImageResponseStructure img = new ImageResponseStructure();
		img.setStatus(status);
		img.setMassage(massage);
		return img;
	}
}
