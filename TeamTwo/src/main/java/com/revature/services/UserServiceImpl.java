package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.pojos.User;

public class UserServiceImpl implements UserService {

	private static UserDao userDao = new UserDaoImpl();
	
	@Override
	public User loginValidation(String username, String password) {
			
		User getUser = null;
		
			for(User user : userDao.getAllUsers()) {
			
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					getUser = user;
					break;
				}
			}
			
			return getUser;
		}
	@Override
	public User getUserByUsername(String username) {
		User thisUser = userDao.getUserByUsername(username);
		return thisUser;
	}
}
