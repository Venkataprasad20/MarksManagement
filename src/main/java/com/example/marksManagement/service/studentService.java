package com.example.marksManagement.service;

import java.util.List;
import java.util.Optional;

import com.example.marksManagement.model.Student;

public interface studentService {
	void deleteStudentByRollNo(String rollNo);
	Optional<Student> getStudentByRollNo(String rollNo);
	List<Student> getAllStudents();
	List<Student> findByName(String name);
	Student updateBranch(String rollNo,String branch);
	Student updateName(String rollNo,String Name);
	Student updateSection(String rollNo,String section);
	List<Student> getListOfStudentsBySection(String section);
	List<Student> getListOfStudentsByBranch(String branch);
	Student getStudentDetails(String rollNo);
}


