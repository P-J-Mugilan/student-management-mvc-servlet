package com.ems_project.model;

import java.sql.*;

//Class for Database Service by implementing the DBService Interface
public class DBServiceClass implements DBService{
	
	//Creating object reference for Connection and Statement Interface
	private Connection con;
	private Statement statement;

	
	//Connecting into ems database
	@Override
	public void connectDB() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","Passwd@123");
			statement = con.createStatement();
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		
		
	}

	//Admin Login method
	@Override
	public boolean verifyAdminLogin(String admin_email, String admin_password) {
		
		try {
			
			ResultSet result = statement.executeQuery("select * from admin_user where admin_email ='"+admin_email+"' and admin_password ='"+admin_password+"'");
			return result.next();
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		return false;
	}
	
	//get admin user by admin email
	@Override
	public ResultSet getAdminUserByAdminEmail(String admin_email) {
		
		try {
			
			ResultSet result = statement.executeQuery("select * from admin_user where admin_email ='"+admin_email+"'");
			return result;
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	//create student registration
	@Override
	public void createStudentRegistration(String student_name, String student_course, String student_email, String student_mobile, int admin_id) {
		
		try {
			statement.executeUpdate("insert into student_user (student_name,student_course,student_email,student_mobile,admin_id) values ('"+student_name+"', '"+student_course+"', '"+student_email+"', '"+student_mobile+"','"+admin_id+"')");
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		
	}
	
	// accessing the student record based on admin_id
	@Override
	public ResultSet getStudentRecordByAdminID(int admin_id) {
		
		try {
			
			ResultSet result = statement.executeQuery("select * from student_user where admin_id ='"+admin_id+"'");
			
			return result;
		} catch (Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	//Deleting the student record by using student_email
	@Override
	public void deleteStudentRecord(String student_email) {
		
		try {
			
			statement.executeUpdate("delete from student_user where student_email = '"+student_email+"'");
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		
	}

	
	//Accessing the student record by using student_id
	@Override
	public ResultSet getStudentRecordByStudentID(int student_id) {
		
		try {
			
			ResultSet result = statement.executeQuery("select * from student_user where student_id ='"+student_id+"'");
			return result;
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	//Updating the student record by using student_id
	@Override
	public void updateStudentRecord(int student_id, String student_name, String student_course, String student_email, String student_mobile) {
		try {
			
			statement.executeUpdate("update student_user set student_name='"+student_name+"', student_course='"+student_course+"',student_email='"+student_email+"',student_mobile='"+student_mobile+"' where student_id='"+student_id+"'");
			
		} catch(Exception err) {
			err.printStackTrace();
		}
		
	}
	

}
