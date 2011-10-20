<%@page import="com.cdstore.entities.Address"%>
<%@page import="com.cdstore.entities.Account"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account Action</title>
</head>
<body>

<%
    String username = request.getParameter("userName");
	String password = request.getParameter("userPassword");
	String verifyPassword = request.getParameter("verifyPassword");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String street = request.getParameter("street");
	String city = request.getParameter("city");
	String province = request.getParameter("province");
	String postalcode = request.getParameter("postalcode");
	String country = request.getParameter("country");
	String phonenumber = request.getParameter("phonenumber");
	
	if ( username != null && username.length() > 0 
		 && password != null && password.length() > 0
		 && verifyPassword != null && verifyPassword.length() > 0
		 && firstName != null && firstName.length() > 0
		 && password.equals(verifyPassword)		 
		) {
    	
    	OrderBean oBean = new OrderBean();
    	
    	Account account = new Account();
    	Address address = new Address();
    	
    	account.setUserName(username);
    	account.setPassword(password);
    	account.setFirstName(firstName);
    	account.setLastName(lastName);
    	address.setStreet(street);
    	//address.setCity(city);
    	address.setProvince(province);
    	//address.setPostalCode(postalcode);
    	address.setCountry(country);
    	address.setPhone(phonenumber);
    	
    	//account.setAddress(address);
    	
    	Account serviceAccount = oBean.createAccount(account);
    	
    	if (serviceAccount != null) {
    		// have account in DB
	    	session.setAttribute("oBean", oBean);   	
	    	session.removeAttribute("loginerror");
	    	session.removeAttribute("createerror");
	    	
	    	session.setAttribute("createsuccess", true);
	    	response.sendRedirect("view/cdstore.jsp");
    	}    	
    }
        
    //redirects before this if has account
    session.setAttribute("createerror", true);
    response.sendRedirect("createaccount.jsp");
%>


</body>
</html>