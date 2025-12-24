package com.example.marksManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.marksManagement.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByRollNo(String rollNo);
}
