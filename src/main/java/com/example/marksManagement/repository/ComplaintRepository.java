package com.example.marksManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marksManagement.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByStatus(String status);

    List<Complaint> findByStudentRollNo(String rollNo);
}
