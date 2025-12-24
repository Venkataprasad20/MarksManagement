package com.example.marksManagement.service;

import com.example.marksManagement.dto.AdminSignUpRequest;
import com.example.marksManagement.dto.SignUpRequest;
import com.example.marksManagement.model.User;

public interface AuthService {
	public String signUp(SignUpRequest req);
	public User Login(String rollNo,String Login);
	public String adminSignUp(AdminSignUpRequest req);
}
