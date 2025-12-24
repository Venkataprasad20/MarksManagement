package com.example.marksManagement.dto;

public class UpdateMarksRequest {
	private String rollNo;
	private String subjectCode;
	private Long marks;
	
	public UpdateMarksRequest(String rollNo,String subjectCode, Long marks) {
		this.rollNo=rollNo;
		this.subjectCode=subjectCode;
		this.marks=marks;
	}
	
	//Getters and Setters
	
	public void setRollNo(String rollNo) {
		this.rollNo=rollNo;
	}
	public String getRollNo() {
		return rollNo;
	}
	
	public void setSubjectCode(String subjectCode) {
		this.subjectCode=subjectCode;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public void setMarks(Long marks) {
		this.marks=marks;
	}
	public Long getMarks() {
		return marks;
	}
}
