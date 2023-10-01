package com.zosh.ecommerceyoutube.service;

import org.springframework.stereotype.Service;

import com.zosh.ecommerceyoutube.exceptions.UserException;
import com.zosh.ecommerceyoutube.model.User;


public interface UserService {

	public User findUserById(Long userId)throws UserException;
	public User findUserProfileByJwt(String jwt) throws UserException;
	
}
