package com.example.marksManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.marksManagement.model.Marks;
import com.example.marksManagement.model.Subject;

public interface MarksRepository extends JpaRepository<Marks,Long>{
	List<Marks>findByStudentIdOrderByIdDesc(Long studentId);
	List<Marks>findBySubjectIdOrderByIdDesc(Long subjectId);
	List<Marks> findByStudentRollNo(String rollNo);
    Optional<Marks> findByStudentRollNoAndSubjectSubjectCode(String rollNo, String subjectCode);
    void deleteByStudentRollNoAndSubjectSubjectCode(String rollNo, String subjectCode);
    boolean existsByStudentRollNoAndSubjectSubjectCode(String rollNo, String subjectCode);
    List<Marks> findBySubjectSubjectName(String subjectName);
    @Query("""
            SELECT DISTINCT m.subject
            FROM Marks m
            WHERE m.student.rollNo = :rollNo
        """)
        List<Subject> findSubjectsByStudentRollNo(@Param("rollNo") String rollNo);
}
