package com.example.marksManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.marksManagement.dto.AddMarksRequest;
import com.example.marksManagement.dto.StudentMarksResponse;
import com.example.marksManagement.dto.StudentMarksSummary;
import com.example.marksManagement.dto.SubjectResponse;
import com.example.marksManagement.dto.UpdateMarksRequest;
import com.example.marksManagement.model.Marks;
import com.example.marksManagement.service.marksService;

@RestController
@RequestMapping("/api/marks")
public class marksController {
	
	@Autowired
	private marksService marService;
	
	@PostMapping("/add")
	public ResponseEntity<Marks> addMarks(@RequestBody AddMarksRequest request){
		return ResponseEntity.ok(marService.addMarks(request));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Marks> updateMarks(@RequestBody UpdateMarksRequest request){
		return ResponseEntity.ok(marService.updateMarks(request));
	}
	
	@GetMapping("/roll/{rollNo}")
	public ResponseEntity<List<StudentMarksResponse>> getMarksByRollNo(@PathVariable String rollNo) {
	    return ResponseEntity.ok(marService.getMarksByRollNo(rollNo));
	}

	@GetMapping("/summary/{rollNo}")
    public ResponseEntity<StudentMarksSummary> getSummary(@PathVariable String rollNo) {
        return ResponseEntity.ok(marService.getStudentMarksSummary(rollNo));
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMarks(@RequestParam String rollNo,@RequestParam String subjectCode){
		marService.deleteMarks(rollNo,subjectCode);
		return ResponseEntity.ok("Marks Deleted Successfully! ");
	}
	
	@GetMapping("/subject/{rollNo}")
	public ResponseEntity<List<SubjectResponse>> getSubjetsList(@PathVariable String rollNo){
		return ResponseEntity.ok(marService.getSubjectsList(rollNo));
	}
}
