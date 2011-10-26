<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:choose>
        <c:when test="${createerror}">
        	<p class="errormessage">${errorMessage}</p>
        </c:when>  
  </c:choose>
<a href="home">Login Page</a>
<form method="POST" action="<c:url value='createAccount'/>">
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
