package com.spring.example.app.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface IUserService {
	ResponseEntity<String> signUp(Map<String, String> requestMap);
}
