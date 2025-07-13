package com.ems_project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ems_project.model.DBServiceClass;

// Admin Login Controller
@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting admin email and admin password from the Admin Login form
		String admin_email = request.getParameter("admin_email");
		String admin_password = request.getParameter("admin_password");
		
		//Creating object for DBServiceClass
		DBServiceClass service = new DBServiceClass();
		
		//calling connectDB() from DBServiceClass
		service.connectDB();
		
		//calling verifyAdminLogin() from DBServiceClass
		boolean status = service.verifyAdminLogin(admin_email, admin_password);
		
		
		//Checking the status 
		if(status) {
			
			//creating the session of admin_email
			HttpSession session = request.getSession(true);
			session.setAttribute("admin_email", admin_email);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration.jsp");
			rd.forward(request, response);
		} else {
			
			// Creating error message for Unauthorized login
			//setting error message into request object and redirecting into index.jsp
			request.setAttribute("error_message","Invalid email/password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
	}

}
