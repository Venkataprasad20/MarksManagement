package com.example.marksManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.marksManagement.model.Subject;
import com.example.marksManagement.service.marksService;
import com.example.marksManagement.service.subjectService;

@RestController
@RequestMapping("api/subjects")
public class subjectController {
	
	@Autowired
	private subjectService subService;
	
	@Autowired
	private marksService markService;
	
	@PostMapping
	public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
		return ResponseEntity.ok(subService.createSubject(subject));
	}
	
	@PutMapping("/update/name")
	public ResponseEntity<?> updateSubjectName(
	        @RequestParam String subjectCode,
	        @RequestParam String subjectName) {

	    try {
	        subService.updateSubjectName(subjectCode, subjectName);
	        return ResponseEntity.ok("Subject name updated successfully");
	    } catch (RuntimeException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	}

	
	@PutMapping("/update/code")
	public ResponseEntity<?> updateSubjectCode(
	        @RequestParam String subjectName,
	        @RequestParam String subjectCode) {

	    try {
	        subService.updateSubjectCode(subjectName, subjectCode);
	        return ResponseEntity.ok("Subject code updated successfully");
	    } catch (RuntimeException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	}

	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteSubject(@RequestParam String subjectCode){
		subService.deleteSubject(subjectCode);
		return ResponseEntity.ok("Subect deleted successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubjects(){
		return ResponseEntity.ok(subService.getAllSubjects());
	}
	
	@GetMapping("/{rollNo}")
    public ResponseEntity<List<Subject>> getSubjectsByRoll(
            @PathVariable String rollNo) {
        return ResponseEntity.ok(
            markService.getSubjectsByRollNo(rollNo)
        );
    }
}
