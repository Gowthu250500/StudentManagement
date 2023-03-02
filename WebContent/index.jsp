<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Home Page</title>
</head>
<body>
<h1>Student Details!</h1>
<form action="My" method="post">
	<table>
	<tr>
		<td>Name: </td>
		<td> <input type="text" name="tbName" id="tbName" placeholder="Enter Name"/> </td>
	</tr>
		<tr>
		<td>Email: </td>
		<td> <input type="email" name="tbEmail" id="tbEmail" placeholder="Enter Email"/> </td>
	</tr>
		<tr>
		<td>Password: </td>
		<td> <input type="password" name="tbPass" id="tbPass" placeholder="Enter Password"/> </td>
	</tr>
		<tr>
		<td> State: </td>
				<td> <select name="ddlStates"> 
					 <option>---Select---</option>
					 <option value="Karnataka">KA</option>
					 <option value="Tamil Nadu">TN</option>
					 <option value="Andra Pradesh">AP</option>
					 <option value="Kerala">KL</option>
					 <option value="Maharastra">MH</option>
					 <option value="West Bengal">WB</option>
					 </select> 
				</td>
	 	</tr>
	</table> <br><br>

<table>
	<tr>
		<td><input type="submit" value="insert" name="crud"/></td>
		<td><input type="submit" value="update" name="crud"/></td>
		<td><input type="submit" value="delete" name="crud"/></td>
		<td><input type="submit" value="Show All" name="crud"/></td>
	
</table>
</form>

</body>
</html>