
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


	
	
	<!--display checkout info
		purchase summary
		shipping summary
		taxes
		total due 
	 -->
	
	

	Your order contains the following items:
	<table >
<!-- 	<tr><th>Item</th><th>Unit Price</th><th>Quantity</th><th>Total Price</th></tr> -->
	<c:set var="details" value="${order.orderDetails}"/>
	
	<!-- SET ALL CURRENCY TO ENGLISH CANADA -->
	<fmt:setLocale value="en_CA"/>
	<!-- output the details for each item in the order -->
	<c:forEach var="cartItem" items="${cart.items}">
		<tr>
		<td>${cartItem.title }</td>
		<td><fmt:formatNumber type="currency" value="${cartItem.price }" /></td>
		<td>${cartItem.quantity }</td>
		<td><fmt:formatNumber type="currency" value="${cartItem.amount }" /></td>
		<td></td>
		</tr>
	 </c:forEach>
	</table>
	</br>
	<em>Billing Information</em>

	<!-- CALCULATE THE COST OF THE ORDER -->
	<table>
	<tr><td>Total Before Tax:</td><td align="right"><fmt:formatNumber type="currency" value="${cart.subtotal}" /></td></tr>
	<tr><td>Tax:</td><td align="right"><fmt:formatNumber type="currency" value="${cart.tax}" /></td>
	<tr><td>Grand Total:</td><td align="right"><fmt:formatNumber type="currency" value="${cart.total}" /></td></tr>
	</table>
	</br>
	<!-- PRINT OUT SHIPPING INFORMATION -->
	<em>Shipping Information:</em>
	<table>
	<tr><td>Street:</td><td>${order.account.address.street}</td></tr>
	<tr><td>City:</td><td>${order.account.address.city}</td></tr>
	<tr><td>Province</td><td>${order.account.address.province}</td></tr>
	<tr><td>Postal Code:</td><td>${order.account.address.postalCode}</td></tr>
	<tr><td>Country</td><td>${order.account.address.country}</td></tr>
	<tr><td>Phone:</td><td>${order.account.address.phone}</td></tr>
	</table>
	
	<form method="POST" action="<c:url value='confirmOrder'/>">
		<p>Credit Card Number: <input type="text" name="ccNumber" /></p>
		<p>Security Code: <input type="password" name="secCode" /></p>
		<p><input type="submit" value="Confirm Order" /></p>
	</form>

	<a href="cancelOrder">Cancel Order</a>


          