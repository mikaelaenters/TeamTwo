package com.revature.daos;

import java.util.List;

import com.revature.pojos.Attendance;

public interface AttendanceDao {
	
	public void createAttendance(int userIdNumber, int classId);
	public List<Attendance> getAllAttendance(int userId);
}
