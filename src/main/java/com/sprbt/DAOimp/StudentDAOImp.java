package com.sprbt.DAOimp;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sprbt.DAO.StudentRepository;
import com.sprbt.entity.Student;

public class StudentDAOImp implements StudentRepository{

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	public void deleteInBatch(Iterable<Student> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public Student getOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Student> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Student arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Student> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Student findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends Student> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <S extends Student> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Student> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<Student> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student withIdAndNameQuery(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student setName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
