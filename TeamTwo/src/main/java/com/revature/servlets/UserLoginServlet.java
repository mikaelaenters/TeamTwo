package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;


public class UserLoginServlet extends HttpServlet{
	
	private static UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		User currentUser = userService.loginValidation(username, password);
		
		if (currentUser == null) {
			
			response.setStatus(401);  
			response.getWriter().write("Incorrect Login. Try Again!");
			response.sendRedirect("login.html");

		} else {
		
			HttpSession session = request.getSession(true);
			session.setAttribute("user", currentUser);
			if(currentUser.getUserRole().equals("Student")) {
				
				response.sendRedirect(request.getContextPath() +"/student.html");
				
			}else {
				//response.sendRedirect(request.getContextPath() +"/student.html");
			}
	
		}
	}

}
