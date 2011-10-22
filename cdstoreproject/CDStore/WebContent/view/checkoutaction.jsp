<%@page import="com.cdstore.entities.Order"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

	ShoppingCartBean shopBean = (ShoppingCartBean)session.getAttribute("shopBean");

	OrderBean oBean = (OrderBean)session.getAttribute("oBean"); 

	//create order once user decides to checkout
	
	oBean.createOrder(shopBean.getShoppingCart());
	
	response.sendRedirect("../controller?actionName=viewCheckout");
	
%>