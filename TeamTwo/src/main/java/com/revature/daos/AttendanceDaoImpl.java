package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Attendance;
import com.revature.pojos.User;

public class AttendanceDaoImpl implements AttendanceDao {

	private static Connection connection = ConnectionFactory.getConnection();
	@Override
	public void createAttendance(int userIdNumber, int classId) {
	
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into attendance (user_id, class_id) values (?, ?)");
			pstmt.setInt(1, userIdNumber);
			pstmt.setInt(2, classId);
			
			connection.setAutoCommit(false);  //needs to be done to run transactions
			Savepoint sp = connection.setSavepoint("Before Insert");

			pstmt.execute();
			
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Attendance> getAllAttendance(int userIdNumber) {
		List<Attendance> allAttendance = new ArrayList<Attendance>();
		
		String sql = "select * from attendance where user_id = " + userIdNumber;
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) { 
				
				String subject = null;
				
				switch(rs.getInt(2)) {
				
				case 1: subject = "Potions";
								break;
								
				case 2: subject = "Math";
							 break;
				
				case 3: subject = "Charms";
							   break;
				};
				
				allAttendance.add(new Attendance(rs.getInt(1), subject, rs.getString(3)));
			} 
		} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return allAttendance;
	}
	
}
