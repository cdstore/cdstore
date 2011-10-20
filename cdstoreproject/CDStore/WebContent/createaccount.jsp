<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New CDStore Account</title>
</head>
<body>

	<%
		if(session.getAttribute("createerror") != null){
	%>
	<p class="errormessage">Account creation error! Please check your values.</p>
	<%
		}
	%>

	<form method="POST" action="createaccountaction.jsp">
		<p>Username: <input type="text" name="userName" /></p>
		<p>Password: <input type="password" name="userPassword" /></p>
		<p>Verify Password: <input type="password" name="verifyPassword" /></p>
		<p>First Name: <input type="text" name="firstName" /></p>
		<p>Last Name: <input type="text" name="lastName" /></p>
		
		<p>Address</p>
		<p>Street Name and Number: <input type="text" name="street" /></p>
		<p>City: <input type="text" name="city" /></p>
		<p>Province: <input type="text" name="province" /></p>
		<p>Postal Code: <input type="text" name="postalcode" /></p>
		<p>Country: <input type="text" name="country" /></p>
		<p>Phone Number: <input type="text" name="phonenumber" /></p>
		
		<p><input type="submit" value="Create Account" /></p>
	</form>

</body>
</html>