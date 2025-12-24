package com.example.marksManagement.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentRollNo;
    private String studentName;

    private String complaintType; // MARKS, DETAILS, SUBJECT

    @Column(columnDefinition = "TEXT")
    private String message;

    private String status = "PENDING";

    @Column(columnDefinition = "TEXT")
    private String adminReply;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime resolvedAt;

    /* ================= CONSTRUCTORS ================= */

    // Default constructor (required by JPA)
    public Complaint() {
    }

    // Constructor for creating a complaint (student side)
    public Complaint(String studentRollNo, String studentName, String complaintType, String message) {
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.complaintType = complaintType;
        this.message = message;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    // Full constructor (optional – admin or testing)
    public Complaint(Long id, String studentRollNo, String studentName, String complaintType,
                     String message, String status, String adminReply,
                     LocalDateTime createdAt, LocalDateTime resolvedAt) {
        this.id = id;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.complaintType = complaintType;
        this.message = message;
        this.status = status;
        this.adminReply = adminReply;
        this.createdAt = createdAt;
        this.resolvedAt = resolvedAt;
    }

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdminReply() {
        return adminReply;
    }

    public void setAdminReply(String adminReply) {
        this.adminReply = adminReply;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
