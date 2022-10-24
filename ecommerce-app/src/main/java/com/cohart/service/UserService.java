package com.cohart.service;

import com.cohart.repository.UserRepository;
import com.cohart.to.User;

public class UserService {

//	public boolean validateUser(String username, String password) throws Exception {
//
//		UserRepository userRepository = new UserRepository();
//
//		boolean validatedUserStatus = userRepository.validateUserCredentials(username, password);
//		
//		return validatedUserStatus;
//	}

	public User validateUser(String username, String password) throws Exception {

		UserRepository userRepository = new UserRepository();

		User user = userRepository.validateUserCredentials(username, password);
		
		return user;
	}
	
}
