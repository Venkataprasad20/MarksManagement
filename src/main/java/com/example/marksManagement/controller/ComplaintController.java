package com.example.marksManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.marksManagement.model.Complaint;
import com.example.marksManagement.service.ComplaintService;


@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class ComplaintController {

    private final ComplaintService complaintService;
    
    public ComplaintController(ComplaintService complaintService) {
    	this.complaintService=complaintService;
    }

    // ================= STUDENT =================

    // Student submits complaint
    @PostMapping
    public ResponseEntity<Complaint> createComplaint(
            @RequestBody Complaint complaint) {
        return ResponseEntity.ok(
                complaintService.createComplaint(complaint)
        );
    }

    // Student views own complaints
    @GetMapping("/student/{rollNo}")
    public ResponseEntity<List<Complaint>> getStudentComplaints(
            @PathVariable String rollNo) {
        return ResponseEntity.ok(
                complaintService.getComplaintsByStudentRollNo(rollNo)
        );
    }

    // ================= ADMIN =================

    // Admin views all complaints
    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(
                complaintService.getAllComplaints()
        );
    }

    // Admin views pending complaints
    @GetMapping("/pending")
    public ResponseEntity<List<Complaint>> getPendingComplaints() {
        return ResponseEntity.ok(
                complaintService.getPendingComplaints()
        );
    }

    // Admin resolves complaint
    @PutMapping("/{id}/resolve")
    public ResponseEntity<Complaint> resolveComplaint(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        return ResponseEntity.ok(
                complaintService.resolveComplaint(
                        id,
                        request.get("adminReply")
                )
        );
    }
}
