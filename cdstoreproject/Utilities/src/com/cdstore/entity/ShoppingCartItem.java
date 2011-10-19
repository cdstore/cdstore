package com.cdstore.entity;

public class ShoppingCartItem {
	Cds Cd;
	Integer Quantity;
	
	public ShoppingCartItem(Cds cd){
		this.Cd=cd;
		this.Quantity=1;
	}
	public void setCD(Cds cd){
		this.Cd=cd;
	}
	public void setQuantity(Integer Quantity){
		this.Quantity=Quantity;
	}
	public Cds getCds(){
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
