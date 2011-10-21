<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
		
<%
	if(session.getAttribute("loginerror") != null){
%>
<p class="errormessage">Please check your username and password!</p>
<%
	}
%>

<form method="POST" action="controller?actionName=loginAction">
	<p>Username: <input type="text" name="userName" /></p>
	<p>Password: <input type="password" name="userPassword" /></p>
	<p><input type="submit" value="Login" /></p>
</form>

<a href="controller?actionName=createAccount">Sign Up!</a>