package com.revature.services;

import com.revature.pojos.User;

public interface UserService {


	public User loginValidation(String username, String password);
	public User getUserByUsername(String username);
	
	
}
