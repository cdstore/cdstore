
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>


<br />
 <c:choose>
        <c:when test="${createSuccess==true}">
        	<p class="successmessage"> Your account was created with username: ${account.userName}</p><br />
        </c:when>  
  </c:choose>



Welcome to the DreamTeam CD Store, ${account.userName}! Please choose a category below:<br /><br />

<!-- Left column with category selection -->
<div id="leftdiv">
	Categories:	<br />
	<!-- catergory of -1 means 'All' is selected and all CDs are shown -->
	<a href="viewCategory?-1">All</a><br />

	<!-- retrieve all categories via CDStoreBean -->
	<c:forEach var="category" items="${categories}">
		<a href="<c:url value='viewCategory?${category.categoryID}'/>">${category.categoryName}</a><br />
</c:forEach>

</div>

	
<!-- Right column with resulting CDs -->
<div id="rightdiv">
	
<!-- get CDs and display category name -->
		${selectedCategory}:<br />
		  <!-- set the local to english canada -->
<fmt:setLocale value="en_CA"/>	
	<table>
	
	<!-- output the details for each CD along with an "Add to Cart" link -->
	<c:forEach var="cd" items="${CDS}" varStatus="iter">
	<tr>
		<td>${cd.title } by ${cd.artist } (${cd.label })</td>
		<td><fmt:formatNumber type="currency" value="${cd.price }" /></td>
		<td><a href="<c:url value='addToCart?${cd.cdid }'/>">Add to Cart</a></td>
	</tr>
	</c:forEach>
	</table>
</div>
<div id="footer">
<a href="viewCart">View Shopping Cart</a>
</div>
<br />
