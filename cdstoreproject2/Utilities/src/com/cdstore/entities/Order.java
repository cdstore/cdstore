package com.cdstore.entities;

import java.util.Date;

public class Order {
	private Account account;
	private String status;
	private Date dateOrdered;
	private Double amount;
	private Integer orderID;
	private OrderDetails[] orderDetails;

	public Order(){
	}
	public Order(Account account, String status, Date dateOrdered, Double amount, Integer orderID, OrderDetails[] orderDetails){
		this.account=account;
		this.status=status;
		this.dateOrdered=dateOrdered;
		this.amount=amount;
		this.orderID=orderID;
		this.orderDetails=orderDetails;
	}	
	public Account getAccount(){
		return this.account;
	}
	public void setAccount(Account account){
		this.account=account;
	}
	public String getStatus(){
		return this.status;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public Date getDateOrdered(){
		return this.dateOrdered;
	}
	public void setDateOrdered(Date dateOrdered){
		this.dateOrdered=dateOrdered;
	}
	public Double getAmount(){
		return this.amount; 
	}
	public void setAmount(Double amount){
		this.amount=amount;
	}
	public Integer getOrderID(){
		return this.orderID;
	}
	public void setOrderID(Integer orderID){
		this.orderID=orderID;
	}
	public OrderDetails[] getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails[] orderDetails) {
		this.orderDetails = orderDetails;
	}
}
