package com.sprbt.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprbt.DAO.StudentRepository;
import com.sprbt.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentRepository repository ;    
	
	@RequestMapping("/getAllStudent")
	public List<Student> getAllStudentInfo(){
		
		
		return repository.findAll();
	}
	
}
