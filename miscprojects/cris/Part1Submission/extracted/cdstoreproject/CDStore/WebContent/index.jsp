<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <c:choose>
        <c:when test="${loginerror!=''}">
        	<p class="errormessage">${loginerror}</p>
        </c:when>  
  </c:choose>	

<form method="POST" action="<c:url value='loginAction'/>">
	<p>Username: <input type="text" name="userName" value="${param.userName}"/></p>
	<p>Password: <input type="password" name="userPassword" value="${param.userPassword }" /></p>
	<p><input type="submit" value="Login" /></p>
</form>

<a href="createAccountPage">Sign Up!</a>