<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.techpalle.model.Student" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<h1>Student Details</h1>
<table border="1" cellspacing="0">
	<tr>
		<th>Student ID</th>
		<th>Student Name</th>
		<th>Student Email</th>
		<th>Student Password</th>
		<th>Student State</th>
	</tr>
	
		<%
			ArrayList<Student> s = (ArrayList<Student>) request.getAttribute("showAll");
			for (Student item:s)
			{
				out.print("<tr>");
				out.print("<td>"+item.getSid()+"</td>");
				out.print("<td>"+item.getName()+"</td>");
				out.print("<td>"+item.getEmail()+"</td>");
				out.print("<td>"+item.getPassword()+"</td>");
				out.print("<td>"+item.getState()+"</td>");
				out.print("</tr>");
			}
		%>
		
</table>
</body>
</html>