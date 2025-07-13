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

//DeleteController here do deleting student record
@WebServlet("/deleteStudentRecordController")
public class DeleteStudentRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteStudentRecordController() {
        super();
        
    }

	//Do get method is does delete operation when we clicking delete button at list_registration_users.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//Getting the student_email by clicking corresponding user deletion button
			String student_email = request.getParameter("student_email");
			
			
			//Creating DBServiceClass object and make connection into the database
			DBServiceClass service = new DBServiceClass();
			service.connectDB();
			
			
			//invoking this method will help to delete student record based on corresponding student_email
			service.deleteStudentRecord(student_email);
			
			//calling the session to get activate admin user email
			HttpSession session = request.getSession(false);
			String admin_email = (String) session.getAttribute("admin_email");
			
			
			//getting admin user details by using session admin_email
			ResultSet result = service.getAdminUserByAdminEmail(admin_email);
			
			int admin_id = 0;
			
			if(result.next()) {
				
				//getting admin_id by result and store into admin_id
				admin_id = result.getInt(1);
			}
			
			
			//Reading the student records based on session activate admin user with help of admin_id
			ResultSet studentRecordResult = service.getStudentRecordByAdminID(admin_id);
			
			//storing the student records into studentRecordResult reference
			request.setAttribute("studentRecordResult", studentRecordResult);
			
			
			//Redirecting to list_registration_users and we access student list with the help of studentRecordResult reference
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/list_registration_users.jsp");
			rd.forward(request, response);

		} catch(Exception err) {
			err.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
