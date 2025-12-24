package com.example.marksManagement.dto;

public class AdminSignUpRequest {
	
	private String rollNo;
	private String password;
	
	public AdminSignUpRequest(String rollNo,String password){
		this.rollNo=rollNo;
		this.password=password;
	}
	
	//getters and setters
	
	public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
