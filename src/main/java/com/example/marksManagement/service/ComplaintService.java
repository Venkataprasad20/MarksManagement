package com.example.marksManagement.service;

import java.util.List;

import com.example.marksManagement.model.Complaint;

public interface ComplaintService {

    // Student raises a complaint
    Complaint createComplaint(Complaint complaint);

    // Admin views all complaints
    List<Complaint> getAllComplaints();

    // Admin views only pending complaints
    List<Complaint> getPendingComplaints();

    // Student views their own complaints
    List<Complaint> getComplaintsByStudentRollNo(String rollNo);

    // Admin resolves complaint
    Complaint resolveComplaint(Long complaintId, String adminReply);
}
