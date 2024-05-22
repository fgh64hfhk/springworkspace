package com.spring.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.example.app.POJO.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer>{

}
