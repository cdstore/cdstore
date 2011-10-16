<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <sql:setDataSource dataSource="jdbc/cdstore"/>
    <sql:query var="result">
    	Select * from category
    </sql:query>
	<div id="leftColumn">
		<div id="welcometext">
			<p>[Welcome text]</p>
		</div>
	This is the Menu
	</div>
	<div id="rightColumn">
	<c:forEach var="category" items="${result.rows}">
	
	
	<div class="categorybox">
		<a href="category?${category.Categoryid }">
			<span class="categorylabletext">${category.category}</span>
			<img src="${initParam.categoryImagePath}${category.category}.jpg" alt="${initParam.categoryImagePath}${category.category }.jpg" />
		</a>
	</div>
	
	</c:forEach>
	</div>
