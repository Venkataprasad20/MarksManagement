package com.example.marksManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.marksManagement.dto.AdminSignUpRequest;
import com.example.marksManagement.dto.SignUpRequest;
import com.example.marksManagement.model.Student;
import com.example.marksManagement.model.User;
import com.example.marksManagement.repository.StudentRepository;
import com.example.marksManagement.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Transactional
	@Override
	public String signUp(SignUpRequest req) {
		if(studentRepository.findByRollNo(req.getRollNo()).isPresent()) {
			throw new RuntimeException("Student already Found");
		}
		
		if (!req.getPassword().equals(req.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }
		
			Student student=new Student(
					req.getName(),
					req.getRollNo(),
					req.getBranch(),
					req.getSection()
			);
			studentRepository.save(student);
		
		String encryptPassword=passwordEncoder.encode(req.getPassword());
		
		User user=new User(
				req.getRollNo(),
				encryptPassword
		);			
		userRepository.save(user);
		return "Student Registered Successfully";
	}
	
	@Override 
	public String adminSignUp(AdminSignUpRequest req) {
		if(userRepository.findByRollNo(req.getRollNo()).isPresent()) {
			throw new RuntimeException("Admin already exists!");
		}
		
		String encrypPassword=passwordEncoder.encode(req.getPassword());
		User user=new User(
				req.getRollNo(),
				encrypPassword
		);
		userRepository.save(user);
		return "Admin Registered Successfully";
	}
	
	@Override
	public User Login(String rollNo,String password) {
		User exist=userRepository.findByRollNo(rollNo)
			.orElseThrow(() -> new RuntimeException("User not found"));
		if(!passwordEncoder.matches(password,exist.getPassword())) {
			throw new RuntimeException("Invalid password");
		}
		else {
			return exist;
		}
	}
}



