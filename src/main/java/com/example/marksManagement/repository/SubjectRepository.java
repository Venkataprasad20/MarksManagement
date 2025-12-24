package com.example.marksManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marksManagement.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long>{
	Optional<Subject>findBySubjectCode(String subjectCode);
	Optional<Subject>findBySubjectName(String subjectName);
	void deleteBySubjectCode(String subjectCode);
}
