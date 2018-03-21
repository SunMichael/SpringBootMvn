


package com.sprbt.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sprbt.entity.User;

@Mapper 
public interface UserMapper {     //使用mybatis           

	
	@Insert("INSERT INTO user (name,password,reg_time) VALUES(#{name},#{password},#{regTime})")   //这里直接写实体类和数据库字段对应的属性名称就行
	void addUser(User user);
	
	
	@Select("SELECT * FROM user")
	List<User> getAll();
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({     //实体类属性和数据库字段名字不一致时使用
		@Result(property = "name",column="name"),
		@Result(property = "password",column="password")
	})
	User findById(long id);
	
	@Update("UPDATE user SET name=#{name},password=#{password},img=#{img} WHERE id=#{id}")
	void updateUser(User user);

	@Delete("DELETE FROM user WHERE id=#{id}")
	void deleteById(long id);
	
	
}


/*
 * hibernate和mybatis的区别是 mybatis可以灵活使用sql语句 ，hibernate则可以不使用sql进行操作
 */




