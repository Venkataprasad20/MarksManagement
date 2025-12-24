package com.example.marksManagement.dto;

public class SignUpRequest {

    private String name;        // Only for STUDENT
    private String rollNo;      
    private String branch;      // Only for STUDENT
    private String section;     // Only for STUDENT
    private String password;
    private String confirmPassword;
    private String role;        // NEW → "ADMIN" or "STUDENT"

    public SignUpRequest() {}

    public SignUpRequest(String name, String rollNo, String branch, String section,
                         String password, String confirmPassword, String role) {
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        this.section = section;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
