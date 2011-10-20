package com.cdstore.entities;

public class OrderDetails {
	
	private Integer cdID;
	private Integer orderID;
	private Integer quantity;
	private Float price;

	public OrderDetails(){
	}
	public OrderDetails(Integer cdID, Integer orderID, Integer quantity, Float price){
		this.cdID=cdID;
		this.orderID=orderID;
		this.quantity=quantity;
		this.price=price;
	}
	public Integer getCDID(){
		return this.cdID;
	}
	public void setCDID(Integer cdID){
		this.cdID=cdID;
	}
	public Integer getOrderID(){
		return this.orderID;
	}
	public void setOrderID(Integer orderID){
		this.orderID=orderID;
	}
	public Integer getQuantity(){
		return this.quantity;
	}
	public void setQuantity(Integer quantity){
		this.quantity=quantity;
	}
	public Float getPrice(){
		return this.price;
	}
	public void setPrice(Float price){
		this.price=price;
	}
}

