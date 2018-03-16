package com.sprbt.controller;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprbt.DAO.PageSortDao;
import com.sprbt.DAO.StudentRepository;
import com.sprbt.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentRepository repository ;    
	private PageSortDao psDao ;
	
	@RequestMapping("/getAllStudent")
	public List<Student> getAllStudentInfo(){
		
		
		return repository.findAll();
	}
	
	
	@RequestMapping("/save")
	@org.springframework.cache.annotation.Cacheable(value="usercache", key="'userid' + #id")
	public Student saveOne(@RequestParam("age") Integer age, @RequestParam("name") String name) {
		Student s = new Student();
		s.setAge(age);
		s.setName(name);
		return repository.save(s);
//		return s;
	}
	
	
	@RequestMapping("/findById/{id}")
	public Student findStudentById(@PathVariable(value = "id") Integer id) {
		return repository.findOne(id);
	}
	
	@RequestMapping("/findByName/{name}")
	public List<Student> findByName(@PathVariable("name") String name){
		
		return repository.findByName(name);
	}
	
	
	@RequestMapping("/update")
	public Student updateInfo(@RequestParam("id") Integer id,
			                  @RequestParam("name") String name,
			                  @RequestParam("age") Integer age) {
		Student s = repository.findOne(id);
		s.setAge(age);
		s.setName(name);
		return s;
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		repository.delete(id);
	}
	
	
	@RequestMapping("/pageList")
	public List<Student> getCurrentPageList(@RequestParam("pageNo") Integer pageNo ,
			                                @RequestParam("pageSize") Integer size){
		
//		data sort 数据排序
		Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
		Sort sort = new Sort(order);
		PageRequest sortRequest = new PageRequest(pageNo, size , sort);
		Page<Student> sortPage = psDao.findAll(sortRequest);       //带排序的查询数据
		
		
		
		PageRequest pageRequest = new PageRequest(pageNo , size);
		
		Page<Student> page = psDao.findAll(pageRequest);
		
		long total = page.getTotalElements();     //总数据条数
		System.out.println("总数据条数：" + total );
		
		int number = page.getNumber();        //当前第几页
		System.out.println("当前第几页：" + number );
		
		int totalPages = page.getTotalPages();      //总共页数
		System.out.println("总页数：" + totalPages );
		
		int number2 = page.getNumberOfElements();    //当前页面条数
		System.out.println("当前页面条数：" + number2 );
		
		List<Student> all = page.getContent();
		
		return all;
	}
	
	
	
	
	
	
	
	
	
}
