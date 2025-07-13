<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<!-- Styles for Registration form -->
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    
    
    body {
        background-color: #f5f5f5;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
    }
    
    
    .main-content {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px;
    }
    .register-container {
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        padding: 40px;
        width: 100%;
        max-width: 450px;
        margin: 20px 0;
    }
    
   
    .register-title {
        color: #333;
        text-align: center;
        margin-bottom: 30px;
        font-size: 24px;
        font-weight: 600;
    }
    
    .form-group {
        margin-bottom: 20px;
    }
    
    .form-group label {
        display: block;
        margin-bottom: 8px;
        color: #555;
        font-size: 14px;
        font-weight: 500;
    }
    
    .form-group input,
    .form-group select {
        width: 100%;
        padding: 12px 15px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 14px;
        transition: all 0.3s;
    }
    
    .form-group input:focus,
    .form-group select:focus {
        border-color: #4a90e2;
        outline: none;
        box-shadow: 0 0 0 2px rgba(74, 144, 226, 0.2);
    }
    
    .register-button {
        width: 100%;
        padding: 12px;
        background-color: #4a90e2;
        color: white;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        font-weight: 500;
        cursor: pointer;
        transition: background-color 0.3s;
        margin-top: 10px;
    }
    
    .register-button:hover {
        background-color: #3a7bc8;
    }
    
    .success-message {
        color: white;
        background-color: green;
        border: 1px solid #f5c6cb;
        padding: 10px 15px;
        border-radius: 4px;
        margin-bottom: 20px;
        font-size: 14px;
        text-align: center;
    }
    
    /* Style for select dropdown arrow */
    .form-group select {
        appearance: none;
        -webkit-appearance: none;
        -moz-appearance: none;
        background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e");
        background-repeat: no-repeat;
        background-position: right 10px center;
        background-size: 1em;
    }
    
    
</style>
</head>
<body>
	
	<%@ include file="menu.jsp" %>
	
	
    <!-- Registration Form -->
    <div class="main-content">
	    <div class="register-container">
	        <h1 class="register-title">Register</h1>
	        
	        <!-- success message display -->
	        <% if(request.getAttribute("success_message") != null) { %>
	            <div class="success-message">
	                <%= request.getAttribute("success_message") %>
	            </div>
	        <% } %>
	        
	        <form action="studentRegistrationController" method="POST">
	            <div class="form-group">
	                <label for="name">Full Name</label>
	                <input type="text" id="name" name="student_name" placeholder="Enter your full name" required>
	            </div>
	            
	            <div class="form-group">
	                <label for="course">Course</label>
	                <select id="course" name="student_course" required>
	                    <option value="" disabled selected>Select your course</option>
	                    <option value="java">Java</option>
	                    <option value="java full stack">Java Full Stack</option>
	                    <option value="devops">Devops</option>
	                    <option value="aws">AWS</option>
	                    <option value="cloud computing">Cloud Computing</option>
	                    <option value="cybersecurity">CyberSecurity</option>
	                </select>
	            </div>
	            
	            <div class="form-group">
	                <label for="email">Email Address</label>
	                <input type="email" id="email" name="student_email" placeholder="Enter your email" required>
	            </div>
	            
	            <div class="form-group">
	                <label for="mobile">Mobile Number</label>
	                <input type="tel" id="mobile" name="student_mobile" title="Mobile Number error! Make sure mobile please enter 10 digits..." maxlength="10" placeholder="Enter your mobile number" required>
	            </div>
	            
	            <button type="submit" class="register-button">Register</button>
	            
	           
	        </form>
	    </div>
	  </div>
</body>
</html>