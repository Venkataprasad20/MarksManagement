package com.example.marksManagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.marksManagement.dto.AdminSignUpRequest;
import com.example.marksManagement.dto.LoginRequest;
import com.example.marksManagement.dto.SignUpRequest;
import com.example.marksManagement.model.User;
import com.example.marksManagement.repository.StudentRepository;
import com.example.marksManagement.service.AuthService;

@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	AuthService authService;
	
	@Autowired 
	StudentRepository studentRepository;
	
	@PostMapping("/signup/student")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest req) {
        try {
            String msg = authService.signUp(req);
            return ResponseEntity.ok(msg);                 // 200 OK
        } catch (RuntimeException ex) {
            // return 400 with error message instead of 500
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
	
	@PostMapping("/signup/admin")
	public ResponseEntity<String> adminSignUp(@RequestBody AdminSignUpRequest req){
		return ResponseEntity.ok(authService.adminSignUp(req));
	}
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        try {
            User user = authService.Login(req.getRollNo(), req.getPassword());
            
            boolean isStudent=studentRepository.findByRollNo(req.getRollNo()).isPresent();
            
            return ResponseEntity.ok(
            	Map.of(
            		"rollNo",user.getRollNo(),
            		"type",isStudent?"STUDENT":"ADMIN"
                )
            );       // return ADMIN or STUDENT
        } 
        catch (RuntimeException ex) {
            return ResponseEntity.status(401).body(ex.getMessage());
        }
    }
}
