<%@page import="com.cdstore.entities.CD"%>
<%@page import="com.cdstore.entities.Category"%>
<%@page import="com.cdstore.beans.CDStoreBean"%>
<%@page import="com.cdstore.entities.Account"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CDStore Catalog</title>
</head>
<body>
	<br />
	<%
		//retrieve account information from session (was set by loginaction)
		OrderBean oBean = (OrderBean)session.getAttribute("oBean"); 
		Account account = oBean.getAccount();
	%>

	<%
		//custom message if account was just created
		if(session.getAttribute("createsuccess") != null){
			session.removeAttribute("createsuccess");
	%>
			<p class="successmessage"> Your account was created with username: <%= account.getUserName() %></p><br />
	<%
		}
	%>	
	
	Welcome to the CDStore, <%= account.getUserName() %>! Please choose a category below:<br /><br />

	<!-- Left column with category selection -->
	<div id="leftdiv">
		Categories:	<br />
		<!-- catergory of -1 means 'All' is selected and all CDs are shown -->
		<a href="cdstore.jsp?category=-1">All</a><br />
		
		<%
		//retrieve all categories via CDStoreBean
		CDStoreBean cdBean = (CDStoreBean)session.getAttribute("cdBean"); 
		
		if (cdBean == null) {
			cdBean = new CDStoreBean();
			session.setAttribute("cdBean", cdBean);
		}
		
		Category[] categories = cdBean.getCategoryList();
		
		for (Category category:categories) {
		%>
			<a href="cdstore.jsp?category=<%= category.getCategoryID() %>"><%= category.getCategoryName() %></a><br />
		<%	
		}
		%>
	</div>
	
		
	<!-- Right column with resulting CDs -->
	<div id="rightdiv">
		
		<% 
		
		String categoryStr = request.getParameter("category");
		
		Integer categoryId = null;
		
		if(categoryStr==null){
			categoryId = -1;
		} else {
			categoryId = new Integer(categoryStr);
		}
			
		CD[] cds;
		
		//get CDs and display category name
		if(categoryId==-1){
			cds = cdBean.getCDList();
			%>
			All CDs:<br />
			<%
		} else {
			cds = cdBean.getCDList(categoryId);
			for (Category category:categories) {
				if(categoryId.equals(category.getCategoryID())){
				%>
					<%= category.getCategoryName() %> CDs:<br />
				<%
				break;
				}
			}
		}
		
		for (CD cd:cds) {
		%>
			<a href="addcartaction.jsp?cdid=<%= cd.getID() %>"><%= cd.getTitle() %></a> - Price: $<%= cd.getPrice() %><br />
		<%	
		}
		%>
	</div>
</body>
</html>