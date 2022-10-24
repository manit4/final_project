package com.cohart.service;

import com.cohart.repository.UserRepository;

public class UserService {

	public boolean validateUser(String username, String password) throws Exception {

		UserRepository userRepository = new UserRepository();

		boolean validatedUserStatus = userRepository.validateUserCredentials(username, password);
		
		return validatedUserStatus;
	}

}
