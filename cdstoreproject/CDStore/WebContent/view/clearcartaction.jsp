<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ShoppingCartBean shopBean = (ShoppingCartBean)session.getAttribute("shopBean");
	
	shopBean.clearCart();

	//redirect to cart
	response.sendRedirect("cart.jsp");

%>