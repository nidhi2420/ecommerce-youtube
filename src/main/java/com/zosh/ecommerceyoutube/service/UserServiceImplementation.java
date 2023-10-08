package com.zosh.ecommerceyoutube.service;

import java.net.URI;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.zosh.ecommerceyoutube.config.JwtProvider;
import com.zosh.ecommerceyoutube.exceptions.UserException;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserById(Long userId) throws UserException {
		
		java.util.Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserException("user not exist with id: "+userId);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailFromJwtToken(jwt);
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UserException("user not found with email: "+email);
		}
		return user;
	}

}
