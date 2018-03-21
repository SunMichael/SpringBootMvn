


package com.sprbt.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.sprbt.entity.User;

@Mapper 
public interface UserMapper {     //使用mybatis           

	
	@Insert("INSERT INTO user (name,age) VALUES(#{name},#{age})")
	int addUser(@Param("name")String name , @Param("age") int age);
	
	
	@Select("SELECT * FROM user")
	List<User> getAll();
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({     //实体类属性和数据库字段名字不一致时使用
		@Result(property = "name",column="name"),
		@Result(property = "password",column="password")
	})
	User findById(@Param("id")String id);
	
	@Update("UPDATE user SET name=#{name} WHERE id=#{id}")
	void updateById(@Param("id")String id, @Param("name")String name);

	@Delete("DELETE FROM user WHERE id=#{id}")
	void deleteById(@Param("id")String id);
	
	
}


/*
 * hibernate和mybatis的区别是 mybatis可以灵活使用sql语句 ，hibernate则可以不使用sql进行操作
 */




