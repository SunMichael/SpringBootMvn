


package com.sprbt.DAO;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.repository.query.Param;

import com.sprbt.entity.User;

//@CacheConfig(cacheNames = "users")
public interface UserMapper {           //使用redis操作对象crud

	
	int addUser(@Param("name")String name , @Param("age") int age);
	
	User findById(@Param("id")String id);
	
	void updateById(@Param("id")String id, @Param("name")String name);
	
	void deleteById(@Param("id")String id);
	
	
}
