package com.ems_project.model;


import java.sql.ResultSet;



public interface DBService {
	
	//Connection method for DB service
	public void connectDB();
	
	//Admin Login Verification method
	public boolean verifyAdminLogin(String admin_email, String admin_password);
	
	//get admin_user by admin_email
	public ResultSet getAdminUserByAdminEmail(String admin_email);
	
	//create student registration method
	public void createStudentRegistration(String student_name, String student_course, String student_email, String student_mobile, int admin_id);
	
	//access the student data by based on admin_id
	public ResultSet getStudentRecordByAdminID(int admin_id);
	
	//delete the user by student_email
	public void deleteStudentRecord(String student_email);
	
	//access the student record by student_id
	public ResultSet getStudentRecordByStudentID(int student_id);
	
	//updating the student by student_id
	public void updateStudentRecord(int student_id, String student_name, String student_course, String student_email, String student_mobile);
	
	

}
