<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
	
	<sql:query var="categories" dataSource="jdbc/cdstore">
		SELECT * FROM category
	</sql:query>
	<div id="categoryleftcolumn">
			<c:forEach var="category" items="${categories.rows }"> 
			
				<c:choose>
					<c:when test="${category.Categoryid==pageContext.request.queryString }">
						<div class="categoryButton" id="selectedCategory">
                    		<span class="categoryText">${category.category}</span>
               		 	</div>
						
					</c:when>
					<c:otherwise>
						<a href="category?${category.Categoryid}" class="categoryButton">
                   			 <span class="categoryText">${category.category}</span>
               			 </a>
					
					</c:otherwise>
				</c:choose>
			
			</c:forEach>

	</div>
	<div id="categoryrightcolumn">
	<sql:query var="selectedCategory" dataSource="jdbc/cdstore">
		Select category from category where Categoryid=?
		<sql:param value="${pageContext.request.queryString }"></sql:param>
	</sql:query>
	<sql:query var="categoryProducts" dataSource="jdbc/cdstore">
		Select * from cd where categoryID=?
		<sql:param value="${pageContext.request.queryString }"></sql:param>
	</sql:query>
	 <p id="categoryTitle">[ ${selectedCategory.rows[0].category } ]</p>
		
		
		<table id="productTable">
			
			<c:forEach var="products" items="${categoryProducts.rows}" varStatus="iter">
				   <tr class="${((iter.index % 2)==0) ? 'lightblue' : 'white'}">
                        <td>
                            <img src="${initParam.productImagePath}${products.title}.png" alt="product image">
                        </td>
                        <td >
                            [ ${products.title } ]
                            <br>
                         <!--    <span class="smallText">[ ${products.description} ]</span> -->
                        </td>
                        <td>[&euro; ${products.price} /Unit]</td>
                        <td>
                            <form action="addToCart" method="post">
                            	<input type="hidden"
                            	name="productID" value="${products.cdid}">
                                <input type="submit" value="add to cart">
                            </form>
                        </td>
                    </tr>
			
			</c:forEach>
                 

                   
        </table>
</div>
	