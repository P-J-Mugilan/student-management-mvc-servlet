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

//Update Student Controller update the student record
@WebServlet("/updateStudentRecordController")
public class UpdateStudentRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateStudentRecordController() {
        super();
        
    }

	
  //Do get method is does update operation when we clicking update button at list_registration_users.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//Getting the student_id by clicking corresponding user update button
			int student_id = Integer.parseInt(request.getParameter("student_id"));
			
			
			//Creating DBServiceClass object and make connection into the database
			DBServiceClass service = new DBServiceClass();
			service.connectDB();
			
			//invoking this method will help to get student record based on student_id 
			ResultSet result = service.getStudentRecordByStudentID(student_id);
			
			
			//Storing the student columns data
			int temp_student_id = 0;
			String student_name = null;
			String student_course = null;
			String student_email = null;
			String student_mobile = null;
			
			if(result.next()) {
				temp_student_id = result.getInt(1);
				student_name = result.getString(2);
				student_course = result.getString(3);
				student_email = result.getString(4);
				student_mobile = result.getString(5);
			}
			
			
			//set the data of student into filed variable
			request.setAttribute("student_id", temp_student_id);
			request.setAttribute("student_name", student_name);
			request.setAttribute("student_course", student_course);
			request.setAttribute("student_email", student_email);
			request.setAttribute("student_mobile", student_mobile);
			
			
			//Redirecting to update_student_registration.jsp and we set student data as a form field at update form
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update_student_registration.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
		
	}

	
	
	//Do get method is does update operation when we filling update student record form
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//calling the session to get activate admin user email
			HttpSession session = request.getSession(false);
			String admin_email = (String)session.getAttribute("admin_email");
			
			//storing the columns record of student into a variable by getting with the help update student form
			int student_id = Integer.parseInt(request.getParameter("student_id"));
			String student_name = request.getParameter("student_name");
			String student_course = request.getParameter("student_course");
			String student_email = request.getParameter("student_email");
			String student_mobile = request.getParameter("student_mobile");
			
			
			//Creating DBServiceClass object and make connection into the database
			DBServiceClass service = new DBServiceClass();
			service.connectDB();
			
			//invoking this method will help to update student record based on corresponding student_id
			service.updateStudentRecord(student_id, student_name, student_course, student_email, student_mobile);
			
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

}
