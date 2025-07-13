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

@WebServlet("/readStudentRecordController")
public class ReadStudentRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadStudentRecordController() {
        super();
        
    }

	//Do get method is going to getting the student record based on admin_user
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//accessing admin_email session
			HttpSession session = request.getSession(false);
			String admin_email = (String) session.getAttribute("admin_email");
			
			//Creating object for DBServiceClass and Connecting into the database
			DBServiceClass service = new DBServiceClass();
			service.connectDB();
			
			//Reading the admin user by using session admin_email
			ResultSet result = service.getAdminUserByAdminEmail(admin_email);
			
			int admin_id = 0;
			
			
			if(result.next()) {
				
				//getting admin_id by result and store into admin_id
				admin_id = result.getInt(1);
			}
			
			//Reading the student records based on active admin user
			ResultSet studentRecordResult = service.getStudentRecordByAdminID(admin_id);
			
			
			//set student records into the studentRecordResult
			request.setAttribute("studentRecordResult",studentRecordResult);
			
			
			//Redirecting to list_registration_users and we access student list with the help of studentRecordResult reference
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/list_registration_users.jsp");
			rd.forward(request, response);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
