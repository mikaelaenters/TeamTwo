package com.revature.pojos;

public class User {
	
	//Fields;
	private int userIdNumber;
	private String firstname,
				   lastname,
				   username,
				   password,
				   userRole;
	
	
	//Constructors;
	public User(int userIdNumber, String firstname, String lastname, String username, String password, String userRole) {
		super();
		this.userIdNumber = userIdNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}
	
	public User() {}
	
	//Getters &Setters;
	public int getUserIdNumber() {
		return userIdNumber;
	}
	public void setUserIdNumber(int userIdNumber) {
		this.userIdNumber = userIdNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
