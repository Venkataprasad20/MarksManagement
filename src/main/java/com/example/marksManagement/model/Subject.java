package com.example.marksManagement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="subjects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false ,unique=true)
	private String  subjectCode;
	
	@Column(nullable=false)
	private String subjectName;
	
	@OneToMany(mappedBy="subject",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Marks> marksList;
	
	public Subject() {}
	
	public Subject(String subjectCode,String subjectName) {
		this.subjectCode=subjectCode;
		this.subjectName=subjectName;
	}
	
	//Id
	public void setId(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	//subjectCode
	public void setSubjectCode(String subjectCode) {
		this.subjectCode=subjectCode;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	
	//subjectName
	public void setSubjectName(String subjectName) {
		this.subjectName=subjectName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	
	//marks
	public void setMarksList(List<Marks> marksList) {
		this.marksList=marksList;
	}
	public List<Marks> getMarksList() {
		return marksList;
	}
}
