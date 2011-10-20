package com.cdstore.shoppingcart;

public abstract class ShoppingCartItem {
	protected Integer id;
	protected Float price;
	
	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		
		ShoppingCartItem that = (ShoppingCartItem)obj;
		
		return that.getID().equals(this.getID());
	}
}
