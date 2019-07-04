package com.revature.services;

import java.util.List;

import com.revature.pojos.Attendance;

public interface AttendanceService {

	public void createAttendance(int userIdNumber, String subject);
	public List<Attendance> getAllAttendance(int userId);
}
