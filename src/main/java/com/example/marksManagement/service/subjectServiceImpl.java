package com.example.marksManagement.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.marksManagement.exception.SubjectAlreadyExistsException;
import com.example.marksManagement.model.Subject;
import com.example.marksManagement.repository.SubjectRepository;
import jakarta.transaction.Transactional;

@Service
public class subjectServiceImpl implements subjectService{
	
	private SubjectRepository subjectRepository;
	
	public subjectServiceImpl(SubjectRepository subjectRepository) {
		this.subjectRepository=subjectRepository;
	}
	@Override
	@Transactional
	public Subject createSubject(Subject subject) {

	    if (subjectRepository.findBySubjectCode(subject.getSubjectCode()).isPresent()) {
	        throw new SubjectAlreadyExistsException("Subject code already exists: " + subject.getSubjectCode());
	    }

	    if (subjectRepository.findBySubjectName(subject.getSubjectName()).isPresent()) {
	        throw new SubjectAlreadyExistsException("Subject name already exists: " + subject.getSubjectName());
	    }

	    Subject sub = new Subject(
	        subject.getSubjectCode(),
	        subject.getSubjectName()
	    );
	    return subjectRepository.save(sub);
	}

	@Override
	@Transactional
	public Subject updateSubjectName(String subjectCode,String subjectName) {
		Subject exist=subjectRepository.findBySubjectCode(subjectCode)
				.orElseThrow(()-> new RuntimeException("Subject not found with this id !"+subjectCode));
		exist.setSubjectName(subjectName);
		return subjectRepository.save(exist);
	}
	
	@Override
	@Transactional
	public Subject updateSubjectCode(String subjectName, String newCode) {
	    Subject subject = subjectRepository.findBySubjectName(subjectName)
	            .orElseThrow(() -> new RuntimeException("Subject not found"));

	    // Check if new code already exists
	    if(subjectRepository.findBySubjectCode(newCode).isPresent()) {
	        throw new RuntimeException("Subject code already exists");
	    }

	    subject.setSubjectCode(newCode);
	    return subjectRepository.save(subject);
	}
	
	@Override
	@Transactional
	public void deleteSubject(String subjectCode) {
		if(!subjectRepository.findBySubjectCode(subjectCode).isPresent()) {
			throw new RuntimeException("Subject not found with id! "+subjectCode);
		}
		subjectRepository.deleteBySubjectCode(subjectCode);
	}
	
	@Override
	public List<Subject> getAllSubjects(){
		return subjectRepository.findAll();
	}
}
