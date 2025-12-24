package com.example.marksManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.marksManagement.model.Student;
import com.example.marksManagement.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class studentServiceImpl implements studentService {
	private StudentRepository studentRepository;
	
	public studentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	@Override
	@Transactional
	public Student updateBranch(String rollNo,String branch) {
		Student exist=studentRepository.findByRollNo(rollNo).orElseThrow(()->
		   new RuntimeException("Student id not found with id:"+rollNo));
		exist.setBranch(branch);
		return studentRepository.save(exist);
	}
	
	@Override
	@Transactional
	public Student updateName(String rollNo,String name) {
		Student exist=studentRepository.findByRollNo(rollNo).orElseThrow(()->new RuntimeException("Student id not Found!"+rollNo));
		exist.setName(name);
		return studentRepository.save(exist);
	}
	
	@Override
	@Transactional
	public Student updateSection(String rollNo,String section) {
		Student exist=studentRepository.findByRollNo(rollNo).orElseThrow(()-> new RuntimeException("Student id not found!"+rollNo));
		exist.setSection(section);
		return studentRepository.save(exist);
	}
	
	@Override 
	@Transactional
	public void deleteStudentByRollNo(String rollNo) {
		
		Student stu=studentRepository.findByRollNo(rollNo).orElseThrow(()->new RuntimeException("Student Not Found"+rollNo));
		studentRepository.delete(stu);
	}
	
	@Override
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@Override
	
	public List<Student> findByName(String name){
		return studentRepository.findByNameContainingIgnoreCase(name);
	}
	
	@Override
	public Optional<Student> getStudentByRollNo(String rollNo) {
		return studentRepository.findByRollNo(rollNo);
	}
	
	@Override 
	public List<Student> getListOfStudentsBySection(String section){
		return studentRepository.findBySection(section);
	}
	
	@Override 
	public List<Student> getListOfStudentsByBranch(String branch){
		return studentRepository.findByBranchIgnoreCase(branch);
	}
	
	 @Override
	    public Student getStudentDetails(String rollNo) {
	        return studentRepository.findByRollNo(rollNo)
	                .orElseThrow(() -> new RuntimeException("Student not found"));
	    }
}
