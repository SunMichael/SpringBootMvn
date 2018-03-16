package com.sprbt.DAO;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sprbt.entity.Student;

public interface PageSortDao extends PagingAndSortingRepository <Student , Long> {

	
	
	
}


//查询分页数据