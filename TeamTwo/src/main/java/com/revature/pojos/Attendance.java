package com.revature.pojos;

public class Attendance {
	
	private int userIdNumber;
	private String loginStamp,
				   subject;
	
	
	public Attendance(int userIdNumber, String subject, String loginStamp) {
		this.userIdNumber = userIdNumber;
		this.subject = subject;
		this.loginStamp = loginStamp;
	}
	
	//Getters &Setters;
	
	public int getUserIdNumber() {
		return userIdNumber;
	}
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setUserIdNumber(int userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
	
	public String getLoginStamp() {
		return loginStamp;
	}
	public void setLoginStamp(String loginStamp) {
		this.loginStamp = loginStamp;
	}
}
