package com.example.marksManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(
        name = "marks",
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_roll_no", "subject_code"})
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many students can have many marks entries (but one per subject)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_roll_no", referencedColumnName="rollNo", nullable = false)
    private Student student;

    // Many subjects can appear in many marks entries
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_code", referencedColumnName="subjectCode",nullable = false)
    private Subject subject;

    @Column(nullable = false)
    private Long marks;

    public Marks() {}

    public Marks(Student student, Subject subject, Long marks) {
        this.student = student;
        this.subject = subject;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }
}
