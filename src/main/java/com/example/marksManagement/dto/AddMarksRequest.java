package com.example.marksManagement.dto;

public class AddMarksRequest {
	private String rollNo;
	private String subjectCode;
	private Long marks;
	
	public AddMarksRequest(String rollNo,String subjectCode,Long marks) {
		this.rollNo=rollNo;
		this.subjectCode=subjectCode;
		this.marks=marks;
	}
	
	//getters and setters
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
