package com.example.marksManagement.dto;

public class LoginRequest {
	String rollNo;
	String password;
	
	public LoginRequest() { }
	
	public LoginRequest(String rollNo,String password) {
		this.rollNo=rollNo;
		this.password=password;
	}
	
	//Setters and Getters
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setRollNo(String rollNo) {
		this.rollNo=rollNo;
	}
	public String getRollNo() {
		return rollNo;
	}
}
