package com.spring.example.app.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.example.app.dao.IUserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {

	@Autowired
	IUserDao userDao;

	private com.spring.example.app.POJO.User userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		log.info("Inside loadUserByUsername {}", username);
		userDetail = userDao.findByEmailId(username);
		if (!Objects.isNull(userDetail)) {
			System.out.println("getEmail(): " + userDetail.getEmail());
			System.out.println("getPassword(): " + userDetail.getPassword());
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		} else {
			System.out.println("userDetail is null");
			return null;
		}
	}

	public com.spring.example.app.POJO.User getUserDetail() {
		return userDetail;
	}

}
