<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Menu styles are self-contained -->
<style>
    .main-nav {
        background-color: #3B71CA;
        overflow: hidden;
        width: 100%;
    }
    
    .main-nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }
    
    .main-nav li {
        float: left;
    }
    
    
    .main-nav #first_nav {
        margin-left:200px;
    }
    
    
    .main-nav li a {
        display: block;
        font-size:18px;
        font-weight:bold;
        color: white;
        text-align: center;
        padding: 14px 30px;
        text-decoration: none;
        transition: background-color 0.3s;
    }
    
    .main-nav li a:hover {
        color: #111;
        font-size:16px;
    }
    
    
    .main-nav:after {
        content: "";
        display: table;
        clear: both;
    }
    
    
    
    
	
	
</style>

<nav class="main-nav">
    <ul>
        <li id="first_nav"><a href="studentRegistrationController">Register</a></li>
        <li><a href="readStudentRecordController">Users List</a></li>
        <li><a href="logoutController">Logout</a></li>
        
        
    </ul>
</nav>