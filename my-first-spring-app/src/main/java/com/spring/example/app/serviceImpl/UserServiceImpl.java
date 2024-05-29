package com.spring.example.app.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.spring.example.app.JWT.CustomerUsersDetailsService;
import com.spring.example.app.JWT.JwtUtil;
import com.spring.example.app.POJO.User;
import com.spring.example.app.constents.AppConstants;
import com.spring.example.app.dao.IUserDao;
import com.spring.example.app.service.IUserService;
import com.spring.example.app.utils.AppUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	CustomerUsersDetailsService customerUsersDetailsService;

	@Autowired
	JwtUtil util;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		System.out.println("Inside signup");
		log.info("Inside signup {}", requestMap);
		try {
			if (validateSignUpMap(requestMap)) {
				User user = userDao.findByEmailId(requestMap.get("email"));
				if (Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return AppUtils.getResponseEntity(AppConstants.SUCCESSFUL_REGISTERED, HttpStatus.OK);
				} else {
					return AppUtils.getResponseEntity(AppConstants.EMAIL_ALREADY_EXITS, HttpStatus.BAD_REQUEST);
				}
			} else {
				return AppUtils.getResponseEntity(AppConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AppUtils.getResponseEntity(AppConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
				&& requestMap.containsKey("password")) {
			return true;
		}
		return false;
	}

	private User getUserFromMap(Map<String, String> requestMap) {
		User user = new User();
		user.setName(requestMap.get("name"));
		user.setContactNumber(requestMap.get("contactNumber"));
		user.setEmail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus(requestMap.get("false"));
		user.setRole(requestMap.get("user"));
		return user;
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("Inside login {}");
		try {
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					requestMap.get("email"), requestMap.get("password"));
			
			Authentication auth = authenticationManager.authenticate(authRequest);
			if (auth.isAuthenticated()) {
				if (customerUsersDetailsService.getUserDetail().getStatus().equalsIgnoreCase("true")) {
					return new ResponseEntity<String>(
							"{\"token\":\"" + util.generateToken(customerUsersDetailsService.getUserDetail().getEmail(),
									customerUsersDetailsService.getUserDetail().getRole()) + "\"}",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("{\"message\":\"" + "Wait for admin approval." + "\"}",
							HttpStatus.BAD_REQUEST);
				}
			}

		} catch (Exception e) {
			log.error("{}", e);
		}
		return new ResponseEntity<String>("{\"message\":\"" + "Bad Credentials." + "\"}", HttpStatus.BAD_REQUEST);
	}
}
