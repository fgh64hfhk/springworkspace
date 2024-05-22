package com.spring.example.app.restImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.app.constents.AppConstants;
import com.spring.example.app.rest.IUserRest;
import com.spring.example.app.service.IUserService;
import com.spring.example.app.utils.AppUtils;

@RestController
public class UserRestImpl implements IUserRest {

	@Autowired
	IUserService userService;

	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		try {
			return userService.signUp(requestMap);
		} catch (Exception e) {
			System.out.println(e);
			return AppUtils.getResponseEntity(AppConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
