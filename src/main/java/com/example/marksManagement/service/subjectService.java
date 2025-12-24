package com.example.marksManagement.service;

import java.util.List;

import com.example.marksManagement.model.Subject;

public interface subjectService {
	Subject createSubject(Subject subject);
	Subject updateSubjectName(String subjectCode,String subjectName);
	Subject updateSubjectCode(String subjectName,String subjectCode);
	void deleteSubject(String subjectCode);
	List<Subject> getAllSubjects();
}