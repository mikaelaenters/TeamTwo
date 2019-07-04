package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Attendance;
import com.revature.pojos.User;
import com.revature.services.AttendanceService;
import com.revature.services.AttendanceServiceImpl;

public class AttendanceServlet  extends HttpServlet{
	
	private static AttendanceService attendanceService = new AttendanceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			request.getRequestDispatcher("login").forward(request, response);
			return;
		} else {
			sess = request.getSession();
			user = (User) sess.getAttribute("user");
		
		List<Attendance> allAttendance = attendanceService.getAllAttendance(user.getUserIdNumber());
		
		ObjectMapper om = new ObjectMapper();
		String attendanceString = om.writeValueAsString(allAttendance);
		
		response.getWriter().write(attendanceString);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user;
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("user") == null) {
			request.getRequestDispatcher("login").forward(request, response);
			return;
		} else {
			sess = request.getSession();
			user = (User) sess.getAttribute("user");
			
			System.out.println("Here here here");
		
		
			String body = request.getReader().readLine();
			
			JsonNode parent = new ObjectMapper().readTree(body);
			
			String subject = parent.get("subject").asText();
			attendanceService.createAttendance(user.getUserIdNumber(), subject);
			
		}
	}

}
