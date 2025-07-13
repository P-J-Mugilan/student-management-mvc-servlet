<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Record</title>

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
    
    #table_head{
    	text-align: center;
    	margin: 40px 40px; 
    	font-size: 24px;
    	font-weight: bold;
    }
    table{
    	border-collapse: collapse; 
    	width: 100%; 
    	font-family: Arial, sans-serif;
    }
    .table_header{
    	background-color: #D2D2D2;
    }
    .table_header_column{
    	border: 1px solid black; 
    	padding: 12px; 
    	text-align: center;
    }
    
    .rows{
    	border: 1px solid black;
    	padding: 10px;
    	text-align: center;
    }
    
	 .btn {
	    display: inline-block;
	    padding: 6px 12px;
	    background-color: #4CAF50; /* Green for update */
	    color: white;
	    text-decoration: none;
	    border: none;
	    border-radius: 4px;
	    text-align: center;
	    cursor: pointer;
	    transition: background-color 0.5s ease;
	}
	
	.btn:hover {
	    background-color: #45a049; 
	    font-weight:bold;
	    font-size:14px;
	}
	
	.delete_btn {
	    background-color: #f44340;
	   
	}
	
	.delete_btn:hover {
	    background-color: #d32f2f;
	    font-weight:bold;
	    font-size:14px;
	}

</style>
<body>
	<%@ include file="menu.jsp" %>
	
	<h2 id="table_head">
		Student Record Data
	</h2>
	<table>
		<thead>
			<tr class="table_header">
				<th class="table_header_column">
					Student_ID
				</th>
				<th class="table_header_column">
					Name
				</th>
				<th class="table_header_column">
					Course
				</th>
				<th class="table_header_column">
					Email ID
				</th>
				<th class="table_header_column">
					Mobile No
				</th>
				<th class="table_header_column">
					Update Detail
				</th>
				<th class="table_header_column">
					Detail Record
				</th>
			</tr>
		</thead>
		<tbody>
			
			<%
				ResultSet result = (ResultSet) request.getAttribute("studentRecordResult");
				while (result.next()) {
			%>
			
				<tr>
					<td class="rows">
						<%=result.getInt(1)%>
					</td>
					
					<td class="rows">
						<%=result.getString(2)%>
					</td>
					
					<td class="rows">
						<%=result.getString(3)%>
					</td>
					
					<td class="rows">
						<%=result.getString(4)%>
					</td>
					
					<td class="rows">
						<%=result.getString(5)%>
					</td>
					
					<td class="rows">
						<a href="updateStudentRecordController?student_id=<%=result.getInt(1)%>" class="btn" >Update</a>
					</td>
					
					<td class="rows">
						<a href="deleteStudentRecordController?student_email=<%=result.getString(4)%>" class="btn delete_btn" >Delete</a>
					</td>
				</tr>
			
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>