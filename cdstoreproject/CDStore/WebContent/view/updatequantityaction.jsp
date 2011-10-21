<%@page import="com.cdstore.shoppingcart.ShoppingCartItem"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

	String indexStr = request.getParameter("itemIndex");
	String quantityStr = request.getParameter("newQuantity");
	String actionType = request.getParameter("update");
	
	ShoppingCartBean shopBean = (ShoppingCartBean)session.getAttribute("shopBean"); 
	
	ShoppingCartItem cdItem = shopBean.getShoppingCart().getItemFromIndex(new Integer(indexStr));
	
	if (actionType.equals("Update Quantity")){
		//update quantity in shopping cart
				
		shopBean.updateItemQuantityInShoppingCart(cdItem, new Integer(quantityStr));
		//updateItemQuantity(Integer(itemIndex), Integer(newQuantity));
	} else {
		shopBean.removeItemFromShoppingCart(cdItem);
	}
	
	//redirect to cart
	response.sendRedirect("../controller?actionName=viewCart");
	
%>
