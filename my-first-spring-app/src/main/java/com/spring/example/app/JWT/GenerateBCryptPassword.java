package com.spring.example.app.JWT;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GenerateBCryptPassword {

	public static void main(String[] args) {
		String pwd = "password123";
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded_pwd = encoder.encode(pwd);
		System.out.println(encoded_pwd);
	}

}
