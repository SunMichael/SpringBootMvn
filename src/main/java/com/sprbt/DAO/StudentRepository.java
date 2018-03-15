package com.sprbt.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprbt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findAllStudent();
	
}
