package com.example.marksManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marksManagement.model.Complaint;
import com.example.marksManagement.repository.ComplaintRepository;


@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    
    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
    	this.complaintRepository=complaintRepository;
    }

    // Student creates complaint
    @Override
    public Complaint createComplaint(Complaint complaint) {
        complaint.setStatus("PENDING");
        complaint.setCreatedAt(LocalDateTime.now());
        return complaintRepository.save(complaint);
    }

    // Admin fetches all complaints
    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    // Admin fetches only pending complaints
    @Override
    public List<Complaint> getPendingComplaints() {
        return complaintRepository.findByStatus("PENDING");
    }

    // Student fetches their complaints
    @Override
    public List<Complaint> getComplaintsByStudentRollNo(String rollNo) {
        return complaintRepository.findByStudentRollNo(rollNo);
    }

    // Admin resolves complaint
    @Override
    public Complaint resolveComplaint(Long complaintId, String adminReply) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus("RESOLVED");
        complaint.setAdminReply(adminReply);
        complaint.setResolvedAt(LocalDateTime.now());

        return complaintRepository.save(complaint);
    }
}
