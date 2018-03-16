package com.sprbt.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprbt.entity.User;

public interface UserRepository extends JpaRepository <User ,Long>{
	User findByName(String name);
}
