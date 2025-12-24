package com.example.marksManagement.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.marksManagement.dto.AddMarksRequest;
import com.example.marksManagement.dto.StudentMarksResponse;
import com.example.marksManagement.dto.StudentMarksSummary;
import com.example.marksManagement.dto.SubjectResponse;
import com.example.marksManagement.dto.UpdateMarksRequest;
import com.example.marksManagement.model.Marks;
import com.example.marksManagement.model.Student;
import com.example.marksManagement.model.Subject;
import com.example.marksManagement.repository.MarksRepository;
import com.example.marksManagement.repository.StudentRepository;
import com.example.marksManagement.repository.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class marksServiceImpl implements marksService {

    private final MarksRepository marksRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public marksServiceImpl(MarksRepository marksRepository,
                            StudentRepository studentRepository,
                            SubjectRepository subjectRepository) {
        this.marksRepository = marksRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }
    
    @Override
    @Transactional
    public Marks addMarks(AddMarksRequest request) {

        // 1. Fetch Student
        Student student = studentRepository.findByRollNo(request.getRollNo())
                .orElseThrow(() -> new RuntimeException("Student not found with rollNo: " + request.getRollNo()));

        // 2. Fetch Subject
        Subject subject = subjectRepository.findBySubjectCode(request.getSubjectCode())
                .orElseThrow(() -> new RuntimeException("Subject not found with code: " + request.getSubjectCode()));

        // 3. Insert new marks entry
        Marks marks = new Marks();
        marks.setMarks(request.getMarks());
        marks.setStudent(student);
        marks.setSubject(subject);

        return marksRepository.save(marks);
    }

    @Override
    @Transactional
    public Marks updateMarks(UpdateMarksRequest request) {
        Student student=studentRepository.findByRollNo(request.getRollNo()).
        		orElseThrow(()->new RuntimeException("Student not found with these RollNo"+request.getRollNo()));
        
        Subject subject=subjectRepository.findBySubjectCode(request.getSubjectCode()).
        		orElseThrow(()->new RuntimeException("Subject code not found"+request.getSubjectCode()));
        
        Marks marks=marksRepository.findByStudentRollNoAndSubjectSubjectCode(request.getRollNo(),request.getSubjectCode()).
        		orElseThrow (()-> new RuntimeException("Marks entry not found"));
        
        marks.setMarks(request.getMarks());
        return marksRepository.save(marks);
    }

    @Override
    @Transactional
    public void deleteMarks(String rollNo, String subjectCode) {

        // Check if student exists
        studentRepository.findByRollNo(rollNo)
                .orElseThrow(() -> new RuntimeException("Student not found: " + rollNo));

        // Check if subject exists
        subjectRepository.findBySubjectCode(subjectCode)
                .orElseThrow(() -> new RuntimeException("Subject not found: " + subjectCode));

        // Check marks entry exists
        boolean exists = marksRepository.existsByStudentRollNoAndSubjectSubjectCode(rollNo, subjectCode);

        if (!exists) {
            throw new RuntimeException("Marks not found for rollNo: " + rollNo +
                    " and subjectName: " + subjectCode);
        }
        // Perform delete
        marksRepository.deleteByStudentRollNoAndSubjectSubjectCode(rollNo, subjectCode);
    }
    
    @Override
    public List<StudentMarksResponse> getMarksByRollNo(String rollNo) {

        List<Marks> marksList = marksRepository.findByStudentRollNo(rollNo);

        // IMPORTANT: Do NOT throw exception
        if (marksList.isEmpty()) {
            return Collections.emptyList();
        }

        return marksList.stream()
                .map(m -> new StudentMarksResponse(
                        m.getSubject().getSubjectName(),
                        m.getSubject().getSubjectCode(),
                        m.getMarks()
                ))
                .collect(Collectors.toList());
    }

    
    @Override
    public StudentMarksSummary getStudentMarksSummary(String rollNo) {

        List<Marks> marksList = marksRepository.findByStudentRollNo(rollNo);

        if (marksList.isEmpty()) {
            return new StudentMarksSummary(rollNo, 0L, 0, 0.0, 0.0);
        }

        Long total = marksList.stream()
                .mapToLong(Marks::getMarks)
                .sum();

        int count = marksList.size();

        double avg = total / (double) count;

        // Each subject is out of 100 — modify if needed
        double percentage = (total / (double) (count * 100)) * 100;

        return new StudentMarksSummary(rollNo, total, count, avg, percentage);
    }
    
    @Override
    public List<SubjectResponse> getSubjectsList(String rollNo) {
        List<Marks> marksList = marksRepository.findByStudentRollNo(rollNo);

        return marksList.stream()
                .filter(m -> m.getSubject() != null)   // avoid NPE
                .map(m -> new SubjectResponse(
                        m.getSubject().getSubjectName(),
                        m.getSubject().getSubjectCode()
                ))
                .distinct()
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Subject> getSubjectsByRollNo(String rollNo) {
        return marksRepository.findSubjectsByStudentRollNo(rollNo);
    }
}
