package com.cdstore.entities;

/**
 * Order Detail Entity Object for Order Detail Information
 * @author Nicedan
 *
 */
public class OrderDetails {
	
	private Integer cdID;
	private Integer orderID;
	private Integer quantity;
	private Double price;

	public OrderDetails(){
	}
	public OrderDetails(Integer cdID, Integer orderID, Integer quantity, Double price){
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
	public Double getPrice(){
		return this.price;
	}
	public void setPrice(Double price){
		this.price=price;
	}
}

