package com.example.marksManagement.service;

import java.util.List;

import com.example.marksManagement.dto.AddMarksRequest;
import com.example.marksManagement.dto.StudentMarksResponse;
import com.example.marksManagement.dto.StudentMarksSummary;
import com.example.marksManagement.dto.SubjectResponse;
import com.example.marksManagement.dto.UpdateMarksRequest;
import com.example.marksManagement.model.Marks;
import com.example.marksManagement.model.Subject;

public interface marksService {
	Marks addMarks(AddMarksRequest request);
	Marks updateMarks(UpdateMarksRequest request);
	void deleteMarks(String rollNo,String subjectCode);
	List<StudentMarksResponse> getMarksByRollNo(String rollNo);
	StudentMarksSummary getStudentMarksSummary(String rollNo);
	List<SubjectResponse> getSubjectsList(String rollNo);
	 public List<Subject> getSubjectsByRollNo(String rollNo);
}
