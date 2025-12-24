package com.example.marksManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.marksManagement.model.Student;
import com.example.marksManagement.service.studentService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/students")
public class studentController {
	
	@Autowired
	private studentService stuService;
	
	public studentController(studentService stuService) {
        this.stuService = stuService;
    }
	
	@PutMapping("/update")
	public ResponseEntity<Student> updateBranch(@RequestParam String rollNo,@RequestParam String branch){
		return ResponseEntity.ok(stuService.updateBranch(rollNo, branch));
	}
	
	@PutMapping("/update/name")
	public ResponseEntity<Student> updateName(@RequestParam String rollNo,@RequestParam String name){
		return ResponseEntity.ok(stuService.updateName(rollNo, name));
	}
	
	@PutMapping("/update/section")
	public ResponseEntity<Student> updateSection(@RequestParam String rollNo,@RequestParam String section){
		return ResponseEntity.ok(stuService.updateSection(rollNo,section));
	}
	
	@GetMapping("/roll")
	public ResponseEntity<Optional<Student>> getStudentByRollNo(@RequestParam String rollNo){
		return ResponseEntity.ok(stuService.getStudentByRollNo(rollNo));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Student>> findStudentByName(@RequestParam String name){
		List<Student> list = stuService.findByName(name);
		if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(list);
        }
        return ResponseEntity.ok(list);
	}
	
	@GetMapping("/section")
	public List<Student> getStudentsBySection(@RequestParam String section) {
	    return stuService.getListOfStudentsBySection(section);
	}
	
	@GetMapping("/branch")
	public List<Student> getStudentByBranch(@RequestParam String branch){
		return stuService.getListOfStudentsByBranch(branch);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(stuService.getAllStudents());
	}
	
	@DeleteMapping("/roll")
	public ResponseEntity<String> deleteStudent(@RequestParam String rollNo){
		stuService.deleteStudentByRollNo(rollNo);
		return ResponseEntity.ok("Student deleted Sucessfully");
	}

	@GetMapping("/details/{rollNo}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable String rollNo) {
        Student student = stuService.getStudentDetails(rollNo);
        return ResponseEntity.ok(student);
    }
}
