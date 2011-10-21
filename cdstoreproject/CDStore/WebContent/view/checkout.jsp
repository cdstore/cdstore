<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.cdstore.beans.CDStoreBean"%>
<%@page import="com.cdstore.entities.CD"%>
<%@page import="com.cdstore.entities.OrderDetails"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCart"%>
<%@page import="com.cdstore.entities.Order"%>
<%@page import="com.cdstore.entities.Account"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

	//display checkout info
	//purchase summary
	// shipping summary
	//taxes
	//total due
	
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);  
	
	CDStoreBean cdBean = (CDStoreBean)session.getAttribute("cdBean"); 
	OrderBean oBean = (OrderBean)session.getAttribute("oBean"); 
	Account account = oBean.getAccount();
	
	Order order = oBean.getOrder();
	
	%>

	Your order ID #<%= order.getOrderID() %> contains the following items:
	<table>
	
	<%		
	//ShoppingCart shopCart = shopBean.getShoppingCart();
	
	OrderDetails[] details = order.getOrderDetails();
	
	double total = order.getAmount();
	double amountWithTax = total * 0.05;
	double grandTotal = total + amountWithTax;
	
	//output the details for each item in the order
	for (int i=0; i<details.length; i++) {
		
		CD cd = cdBean.getCDInfo(details[i].getCDID());
		
		%>
		<tr>
		<td><%= cd.getTitle() %></td>
		<td><%= details[i].getPrice() %></td>
		<td><%= details[i].getQuantity() %></td>
		<td><%= details[i].getPrice() * details[i].getQuantity()%></td>
		<td></td>
		</tr>
		<% 
	}
	
	%>
	</table>

	Total Before Tax:
	<%= n.format(total)	%>
	
	Tax:
	<%= n.format(amountWithTax) %>

	Grand Total:
	<%= n.format(grandTotal) %>


	<form method="POST" action="../controller?actionName=confirmOrderAction">
		<p>Credit Card Number: <input type="text" name="ccNumber" /></p>
		<p>Security Code: <input type="password" name="secCode" /></p>
		<p><input type="submit" value="Confirm Order" /></p>
	</form>

	<a href="../controller?actionName=cancelOrderAction">Cancel Order</a>
<%

%>         

          