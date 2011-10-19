package com.cdstore.entity;

import java.math.BigDecimal;
import java.util.Date;



public class Order {
	private Account Account;
	private String Status;
	private Date Dateordered;
	private double Amount;
	private Integer OrderID;
	
	public Account getAccount(){
		return this.Account;
	}
	public void setAccount(Account Account){
		this.Account=Account;
	}
	public String getStatus(){
		return this.Status;
	}
	public void setStatus(String Status){
		this.Status=Status;
	}
	public  Date getDateordered(){
		return this.Dateordered;
	}
	public void getDateOrdered(Date Dateordered){
		this.Dateordered=Dateordered;
	}
	public double getAmount(){
		return this.Amount;
	}
	public void setAmount(double Amount){
		this.Amount=Amount;
	}
	public Integer getOrderID(){
		return this.OrderID;
	}
	public void setOrderID(Integer OrderID){
		this.OrderID=OrderID;
	}
}
