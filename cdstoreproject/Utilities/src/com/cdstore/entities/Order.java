package com.cdstore.entities;

import java.util.Date;

public class Order {
	private Account account;
	private String status;
	private Date dateOrdered;
	private Float amount;
	private Integer orderID;

	public Order(){
	}
	public Order(Account account, String status, Date dateOrdered, Float amount, Integer orderID){
		this.account=account;
		this.status=status;
		this.dateOrdered=dateOrdered;
		this.amount=amount;
		this.orderID=orderID;
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
	public double getAmount(){
		return this.amount;
	}
	public void setAmount(Float amount){
		this.amount=amount;
	}
	public Integer getOrderID(){
		return this.orderID;
	}
	public void setOrderID(Integer orderID){
		this.orderID=orderID;
	}
}