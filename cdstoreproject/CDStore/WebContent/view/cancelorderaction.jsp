<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%

	OrderBean oBean = (OrderBean)session.getAttribute("oBean");
	oBean.confirmOrder("error", "error");

//del order obj & call servvice with -1

%>