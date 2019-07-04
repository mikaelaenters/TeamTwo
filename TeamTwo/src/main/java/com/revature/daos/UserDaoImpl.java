package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;

public class UserDaoImpl implements UserDao {

	private static Connection connection = ConnectionFactory.getConnection();
	
	@Override
	public User getUserByUsername(String username) {
		User getUser = null;
		
		String sql = "select * from users where username = '" + username + "'";
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) { 
				getUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			} 
		} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return getUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> getAllUsers = new ArrayList<User>();
		
		String sql = "select * from users";
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { 
				getAllUsers.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			} 
		} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return getAllUsers;
	}

	@Override
	public List<User> getUsersByType(String type) {
			List<User> getAllByType = new ArrayList<User>();
		
		String sql = "select * from users where user_role = '" + type + "'";
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) { 
				getAllByType.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			} 
		} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return getAllByType;
	}

}
