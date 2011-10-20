<%@page import="com.cdstore.entities.Account"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Action</title>
</head>
<body>

<%
	// retrieve username and password from POST on index.jsp
    String username = request.getParameter("userName");
	String password = request.getParameter("userPassword");

    if ( username != null && username.length() > 0 && password != null && password.length() > 0) {
    	
    	OrderBean oBean = new OrderBean();
    	
    	Account account = oBean.getAccount(username, password);
    	
    	if (account != null) {
    		// have valid account in DB so store in session attribute & load cdstore.jsp
	    	session.setAttribute("oBean", oBean);   	
	    	session.removeAttribute("loginerror");
	    	response.sendRedirect("view/cdstore.jsp");
    	}    	
    }
        
    //redirects before this if has account
    session.setAttribute("loginerror", true);
    response.sendRedirect("index.jsp");
%>

</body>
</html>