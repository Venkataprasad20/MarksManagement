package com.example.marksManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marksManagement.model.Student;


import java.util.List;
import java.util.Optional;
public interface StudentRepository extends JpaRepository<Student,Long>{

	List<Student> findByNameContainingIgnoreCase(String name);
	List<Student> findBySection(String section);
	Optional<Student> findByRollNo(String rollNo);
	List<Student> findByBranchIgnoreCase(String branch);
	void deleteByRollNo(String rollNo);
}
