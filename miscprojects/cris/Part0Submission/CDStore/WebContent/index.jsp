<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sql:query var="rs" dataSource="jdbc/cdstoreDS">
select distinct category from cd
</sql:query>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CD Store</title>
</head>
<body>

<h2>Dream Team Hello World!</h2>

Distinct categories loaded from MySQL:
<ul> 
<c:forEach var="row" items="${rs.rows}">
    <li>${row.category}</li>
</c:forEach>
</ul>

</body>
</html>

