<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%


//will be null if error since using removeattribute
if(session.getAttribute("ordersuccess") != null){
	//null for next time
	session.removeAttribute("ordersuccess");
%>
	<p class="successmessage">Your order was processed successfully!</p>
<%
} else {
	
	%>
	<p class="errormessage">There was a problem processing your order! Please contact a CD Store representative.</p>
	
	<%
}
%>	

	<br />
	<a href="home">Return to CD Store</a>
