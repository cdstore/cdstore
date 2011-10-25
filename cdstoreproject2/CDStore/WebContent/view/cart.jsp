
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- shopping cart contains blah items, clear cart, continue shopping, checkout -->
<!-- prod name, price, quantity -->


	
<!-- 	retrieve shopping cart from session -->

	 <c:choose>
        <c:when test="${cart.numberOfItems > 1}">
        	<br/>
            	Your shopping cart contains ${cart.numberOfItems} items.
            <br/>
        </c:when>
        <c:when test="${cart.numberOfItems == 1}">
        	<br/>
            Your shopping cart contains ${cart.numberOfItems} item.
            <br/>
        </c:when>
        <c:otherwise>
        	<br/>
           		 Your shopping cart is empty.
            <br/>
        </c:otherwise>
    </c:choose>
    
	<%-- ENABLE CLEAR CART BUTTON  ONLY WHEN TEHRE ARE ITEMS IN THE CART
	 --%>
	<c:if test="${!empty cart && cart.numberOfItems != 0}">
		<br />
		<c:url var="url" value="viewCart">
                <c:param name="clear" value="true"/>
            </c:url>

            <a href="${url}" class="bubble hMargin">clear Cart</a>
		<br />
		
		
		<%-- START OF CART ITEMS --%>
		<table>
	</c:if>		

    <c:if test="${!empty cart && cart.numberOfItems != 0}">
    <!-- SET THE LOCAL TO ENGLISH CANADA -->
		<fmt:setLocale value="en_CA"/>		
		 <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

<%--           <c:set var="cd" value="${cartItem.cd}"/> --%>
			
			<form method="POST" action="<c:url value='updateQuantity'/>"><tr>
			<input type="hidden" value="${cartItem.cdid}" name="itemIndex"/>
			<td>${cartItem.title }</td>
			<td><fmt:formatNumber type="currency" value="${cartItem.price}"/></td>
			<td><input type="text" name="newQuantity" value="${cartItem.quantity}"/></td>
			<td><input type="submit" value="Update Quantity" name="update" /></td>
			<td><input type="submit" value="Remove Item" name="delete" /></td>
			</tr></form>
		 </c:forEach>
		</table>
		<br/>
		
		Shopping Cart Total: <fmt:formatNumber type="currency" value="${cart.subtotal}" />
		<br />
		<br />
		<a href="checkout">Checkout</a>		
	
	
	 </c:if>

<br />

<a href="viewCategory?-1">Continue Shopping</a>

          