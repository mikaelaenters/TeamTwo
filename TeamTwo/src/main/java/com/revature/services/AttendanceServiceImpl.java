package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.AttendanceDao;
import com.revature.daos.AttendanceDaoImpl;
import com.revature.pojos.Attendance;

public class AttendanceServiceImpl implements AttendanceService {

	private AttendanceDao attendanceDao = new AttendanceDaoImpl();
	
	@Override
	public void createAttendance(int userIdNumber, String subject) {
		int classId;
		
		switch(subject) {
		
		case "Potions": classId = 1;
						break;
						
		case "Math": classId = 2;
					 break;
		
		default: classId = 3;
					   break;
		};
		
		attendanceDao.createAttendance(userIdNumber, classId);
		
	}

	@Override
	public List<Attendance> getAllAttendance(int userId) {
		List<Attendance> allAttendance = new ArrayList<Attendance>();
		
		allAttendance = attendanceDao.getAllAttendance(userId);
		
		return allAttendance;
	}

}
