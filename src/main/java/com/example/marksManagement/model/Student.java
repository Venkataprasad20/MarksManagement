package com.example.marksManagement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
@Table(name="students")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String rollNo;
	
	@Column(nullable=false)
	private String branch;
	
	@Column(nullable=false)
	private String section;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Marks> marksList;
	
	
	public Student() {}
	
	public Student(String name,String rollNo, String branch, String section) {
		this.name=name;
		this.rollNo=rollNo;
		this.branch=branch;
		this.section=section;
	}
	
	//Id
	public void setId(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	//rollNo
	public void setRollNo(String rollNo) {
		this.rollNo=rollNo;
	}
	
	public String getRollNo() {
		return rollNo;
	}
	
	//Name
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	//branch
	public void setBranch(String branch) {
		this.branch=branch;
	}
	public String getBranch() {
		return branch;
	}
	
	
	//Section
	public void setSection(String section) {
		this.section=section;
	}
	public String getSection() {
		return section;
	}
	
	//marks
	
	public void setMarksList(List<Marks> marksList) {
	    this.marksList = marksList;
	}

	public List<Marks> getMarksList() {
	    return marksList;
	}

}
