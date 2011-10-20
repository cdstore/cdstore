package com.cdstore.shoppingcart;

import com.cdstore.entities.CD;

public class ShoppingCartItem {
	CD Cd;
	Integer Quantity;
	
	public ShoppingCartItem(CD cd){
		this.Cd=cd;
		this.Quantity=1;
	}
	public void setCD(CD cd){
		this.Cd=cd;
	}
	public void setQuantity(Integer Quantity){
		this.Quantity=Quantity;
	}
	public CD getCds(){
		return this.Cd;
	}
	public Integer getQuantity(){
		return this.Quantity;
	}
	 public void incrementQuantity() {
	        Quantity++;
	    }

	    public void decrementQuantity() {
	        Quantity--;
	    }
	    
	    public double getTotal() {
	        double amount = 0;
	        amount = (this.getQuantity() * Cd.getPrice().doubleValue());
	        return amount;
	    }
}
