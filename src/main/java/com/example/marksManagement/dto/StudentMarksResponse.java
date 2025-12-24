package com.example.marksManagement.dto;

public class StudentMarksResponse {

    private String subjectName;
    private String subjectCode;
    private Long marks;

    public StudentMarksResponse(String subjectName, String subjectCode, Long marks) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.marks = marks;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Long getMarks() {
        return marks;
    }
    public void setMarks(Long marks) {
        this.marks = marks;
    }
}
