<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	if(session.getAttribute("createerror") != null){
%>
<p class="errormessage">Account creation error! Please check your values.</p>
<%
	}
%>

<form method="POST" action="controller?actionName=createAccount">
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
