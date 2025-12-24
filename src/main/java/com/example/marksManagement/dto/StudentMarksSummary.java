package com.example.marksManagement.dto;

public class StudentMarksSummary {

    private String rollNo;
    private Long totalMarks;
    private int subjectsCount;
    private double averageMarks;
    private double percentage;

    public StudentMarksSummary() {}

    public StudentMarksSummary(String rollNo, Long totalMarks, int subjectsCount, double averageMarks, double percentage) {
        this.rollNo = rollNo;
        this.totalMarks = totalMarks;
        this.subjectsCount = subjectsCount;
        this.averageMarks = averageMarks;
        this.percentage = percentage;
    }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public Long getTotalMarks() { return totalMarks; }
    public void setTotalMarks(Long totalMarks) { this.totalMarks = totalMarks; }

    public int getSubjectsCount() { return subjectsCount; }
    public void setSubjectsCount(int subjectsCount) { this.subjectsCount = subjectsCount; }

    public double getAverageMarks() { return averageMarks; }
    public void setAverageMarks(double averageMarks) { this.averageMarks = averageMarks; }

    public double getPercentage() { return percentage; }
    public void setPercentage(double percentage) { this.percentage = percentage; }
}
