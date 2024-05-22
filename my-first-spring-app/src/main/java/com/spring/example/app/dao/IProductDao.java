package com.spring.example.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.example.app.POJO.ProductEntity;

public interface IProductDao extends JpaRepository<ProductEntity, Integer>{

}
