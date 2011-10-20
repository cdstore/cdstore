<%@page import="com.cdstore.beans.CDStoreBean"%>
<%@page import="com.cdstore.entities.CD"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCartItem"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String cdid = request.getParameter("cdid");

	ShoppingCartBean shopBean = (ShoppingCartBean)session.getAttribute("shopBean"); 
	
	// check if already have a shopping cart
	if (shopBean==null){
		
		shopBean = new ShoppingCartBean();
		
		session.setAttribute("shopBean", shopBean);
	}
	
	CDStoreBean cdBean = (CDStoreBean)session.getAttribute("cdBean"); 
	
	//returns CD object via service
	ShoppingCartItem cdItem = cdBean.getCDInfo(new Integer (cdid));
		
	shopBean.addItemToShoppingCart(cdItem);	
	
	response.sendRedirect("cart.jsp");

%>