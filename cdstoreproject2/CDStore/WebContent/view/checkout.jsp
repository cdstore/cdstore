
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


	
	
	<!--display checkout info
		purchase summary
		shipping summary
		taxes
		total due 
	 -->
	
	

	Your order ID #${order.orderID} contains the following items:
	<table>
	
	<c:set var="details" value="${order.orderDetails}"/>
	<!-- output the details for each item in the order -->
	<c:forEach var="cartItem" items="${cart.items}">
	
		<tr>
		<td>${cartItem.title }</td>
		<td>${cartItem.price }</td>
		<td>${cartItem.quantity }</td>
		<td>${cartItem.amount }</td>
		<td></td>
		</tr>
	 </c:forEach>
	</table>

	Total Before Tax:${cart.subtotal}
	
	Tax:${cart.tax}

	Grand Total:${cart.total}


	<form method="POST" action="<c:url value='confirmOrder'/>">
		<p>Credit Card Number: <input type="text" name="ccNumber" /></p>
		<p>Security Code: <input type="password" name="secCode" /></p>
		<p><input type="submit" value="Confirm Order" /></p>
	</form>

	<a href="cancelOrder">Cancel Order</a>


          