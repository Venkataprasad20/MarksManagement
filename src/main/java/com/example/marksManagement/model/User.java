package com.example.marksManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // Better: avoid SQL keyword "user"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rollNo;

    @Column(nullable = false)
    private String password;



    public User() {}

    public User(String rollNo, String password) {
        this.rollNo = rollNo;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
