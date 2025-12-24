
package com.example.marksManagement.dto;

public class SubjectResponse {

    private String subjectName;
    private String subjectCode;

    public SubjectResponse(String subjectName, String subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }
}
