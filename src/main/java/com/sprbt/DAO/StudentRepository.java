package com.sprbt.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sprbt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByName(String name);    //方法命名查询
	
	@Query("select s from Student s where s.id=?1 and s.name=?2")
	public Student withIdAndNameQuery(Integer id, String name);   //@Query查询
	
	@Modifying
	@Transactional
	@Query("update Student s set s.name=?1")
	public Student setName(String name);       //修改对象
}



/*
 * Spring data jpa 支持方法命名查询 和 @Query查询
 */
