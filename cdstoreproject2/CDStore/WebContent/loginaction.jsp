<%@page import="com.cdstore.entities.Account"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	    	response.sendRedirect("controller?actionName=loginSuccess");
	    }    	
    }
        
    //redirects before this if has account
    session.setAttribute("loginerror", true);
    
	response.sendRedirect("controller?actionName=loginFailed");
      
%>
