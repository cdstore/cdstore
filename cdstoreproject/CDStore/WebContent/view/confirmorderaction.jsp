<%@page import="com.cdstore.shoppingcart.ShoppingCartBean"%>
<%@page import="com.cdstore.entities.Order"%>
<%@page import="com.cdstore.beans.OrderBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	
	OrderBean oBean = (OrderBean)session.getAttribute("oBean");
	
	//persist for all sessions (done on client since services stateless)
	
	int processedOrders = 0;
	
	if (session.getServletContext().getAttribute("processedOrders")==null){
		session.getServletContext().setAttribute("processedOrders", new Integer(1));
	}
	
	processedOrders = (Integer)session.getServletContext().getAttribute("processedOrders");
		
	if((processedOrders % 5) == 0){
		
		oBean.confirmOrder("error", "error");
		session.removeAttribute("ordersuccess");
		
	} else {
				
	    String ccNumber = request.getParameter("ccNumber");
		String secCode = request.getParameter("secCode");
		
		//confirm successful order
		boolean orderStatus = oBean.confirmOrder(ccNumber, secCode);
		
		session.setAttribute("ordersuccess",true); 
				
		//delete order from bean
		oBean.removeLocalOrder();
		
		//clear shopping cart
		ShoppingCartBean shopBean = (ShoppingCartBean)session.getAttribute("shopBean");
		shopBean.clearCart();
		
	}
	
	processedOrders++;
	
	session.getServletContext().setAttribute("processedOrders",processedOrders);
	
	response.sendRedirect("../controller?actionName=viewResultPage");
	
%>
