<%@page import="com.cdstore.shoppingcart.ShoppingCartItem"%>
<%@page import="com.cdstore.beans.CDStoreBean"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCart"%>
<%@page import="com.cdstore.entities.CD"%>
<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- shopping cart contains blah items, clear cart, continue shopping, checkout -->
<!-- prod name, price, quantity -->

	<% 
	
	//retrieve shopping cart from session
	ShoppingCartBean shopBean = (ShoppingCartBean)session.getAttribute("shopBean"); 
	
	if(shopBean==null || shopBean.getShoppingCart().getSize()==0){
		%>
		<br />
			Your cart is currently empty.
		<br />
		<%
	} else {	
		%>
		<br />
		<a href="../controller?actionName=clearCartAction">Clear Cart</a>
		<br />
		<table>
		<%		
		ShoppingCart shopCart = shopBean.getShoppingCart();
					
		//output the details for each item in the shopping cart
		for (int i=0; i<shopCart.getSize(); i++) {
			
			ShoppingCartItem cdItem = shopCart.getItemFromIndex(i);
			CD cd = (CD)cdItem;
			
			%>
			<form method="POST" action="../controller?actionName=updateQuantityAction"><tr>
			<input type="hidden" value="<%= i %>" name="itemIndex"/>
			<td><%= cd.getTitle() %></td>
			<td><%= cd.getPrice() %></td>
			<td><input type="text" name="newQuantity" value="<%= shopCart.getQuantityByIndex(i) %>"/></td>
			<td><input type="submit" value="Update Quantity" name="update" /></td>
			<td><input type="submit" value="Remove Item" name="update" /></td>
			</tr></form>
			<% 
		}
		
		%>
		</table>
		<br/>
		Shopping Cart Total: <%= shopCart.getTotalPrice() %>
		<br />
		<br />
		<a href="../controller?actionName=checkout">Checkout</a>		
		<%
	
	} // else
	%>

<br />
<a href="../controller?actionName=viewCDStore">Continue Shopping</a>

          