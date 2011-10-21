<%@page import="com.cdstore.entities.CD"%>
<%@page import="com.cdstore.entities.Category"%>
<%@page import="com.cdstore.beans.CDStoreBean"%>
<%@page import="com.cdstore.entities.Account"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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

Welcome to the DreamTeam CD Store, <%= account.getUserName() %>! Please choose a category below:<br /><br />

<!-- Left column with category selection -->
<div id="leftdiv">
	Categories:	<br />
	<!-- catergory of -1 means 'All' is selected and all CDs are shown -->
	<a href="../controller?actionName=viewCategory&category=-1">All</a><br />
	
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
		<a href="../controller?actionName=viewCategory&category=<%= category.getCategoryID() %>"><%= category.getCategoryName() %></a><br />
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
	%>
			
	<table>
	<% 
	//output the details for each CD along with an "Add to Cart" link
	for (CD cd:cds) {
	%>
	<tr>
		<td><%= cd.getTitle() %> by <%= cd.getArtist() %> (<%= cd.getLabel() %>)</td>
		<td>$<%= cd.getPrice() %></td>
		<td><a href="../controller?actionName=addToCartAction&cdid=<%= cd.getID() %>">Add to Cart</a></td>
	</tr>
	<% 
	}
	%>
	</table>
</div>
<div id="footer">
<a href="../controller?actionName=viewCart">View Shopping Cart</a>
</div>
<br />
