package com.spring.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.spring.example.app.POJO.User;

public interface IUserDao extends JpaRepository<User, Integer> {

	User findByEmailId(@Param("email") String email);
}
