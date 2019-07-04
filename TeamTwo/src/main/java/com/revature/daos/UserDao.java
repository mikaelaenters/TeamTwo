package com.revature.daos;

import java.util.List;

import com.revature.pojos.User;

public interface UserDao {
	
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	public List<User> getUsersByType(String type);
	
}
