package com.ems_project.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.ems_project.model.DBServiceClass;

// Registration Controller for inserting the student records
@WebServlet("/studentRegistrationController")
public class StudentRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentRegistrationController() {
        super();
        
    }

	//Do get method is going to forward the request into registration page 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration.jsp");
		rd.forward(request, response);
	}

	//Do post method getting the user details from the registration.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//getting admin_email session
			HttpSession session = request.getSession(false);
			String admin_email = (String) session.getAttribute("admin_email");
			
			//Creating object for DBServiceClass 
			DBServiceClass service = new DBServiceClass();
			
			//invoking the Database Connection
			service.connectDB();
			
			//Reading the admin user record by using session admin_email
			ResultSet result = service.getAdminUserByAdminEmail(admin_email);
			
			
			int admin_id = 0;
			if(result.next()) {
				
				//getting admin_id by result and store into admin_id
				admin_id = result.getInt(1);
			}
			
			//Accessing the data from registration form in registration.jsp and access accordingly
			String student_name = request.getParameter("student_name");
			String student_course = request.getParameter("student_course");
			String student_email = request.getParameter("student_email");
			String student_mobile = request.getParameter("student_mobile");
			
			
			//invoking the student registration
			service.createStudentRegistration(student_name, student_course, student_email, student_mobile, admin_id);
			
			//success_message will Registration Successful
			request.setAttribute("success_message", "Registration Successful");
			
			//Redirect to registration.jsp after the one student record is successfully done
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/registration.jsp");
			
			rd.forward(request, response);
		} catch(Exception err) {
			
			err.printStackTrace();
		}
	}

}
