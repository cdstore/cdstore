package com.cdstore.shoppingcart;

import java.util.ArrayList;

public class ShoppingCart {

	private ArrayList<ShoppingCartItem> item;
	private ArrayList<Integer> itemQuantity;
	
	//totalAmount
	
	public ShoppingCart(){
		this.item = new ArrayList<ShoppingCartItem>();
		this.itemQuantity = new ArrayList<Integer>();
	}
	
	public void addItem(ShoppingCartItem item){
		int index = this.item.indexOf(item);
		
		if(index!=-1){
			int increasedVal = this.itemQuantity.get(index) + 1;
			this.itemQuantity.set(index, increasedVal);
		} else{
			this.item.add(item);
			this.itemQuantity.add(1);
		}
	}
	
	public void removeItem(ShoppingCartItem item){
		int itemIdIndex = this.item.indexOf(item);
		this.item.remove(itemIdIndex);
		this.itemQuantity.remove(itemIdIndex);
	}
	
	public void updateItemQuantity(int itemIndex, int newQuantity){
		this.itemQuantity.set(itemIndex, newQuantity);
	}
	
	public ShoppingCartItem getItemFromIndex(int itemIndex){
		ShoppingCartItem scItem = this.item.get(itemIndex);
		return scItem;
	}
	
	public int getIndexFromItem(ShoppingCartItem item){
		int index = this.item.indexOf(item);
		return index;
	}
	
	public int getQuantityByIndex(int index) {
		return this.itemQuantity.get(index);
	}

	public int getSize() {
		return this.item.size();
	}

	public void clear() {
		this.item.clear();
		this.itemQuantity.clear();
	}
	
	public Float getTotalPrice() {
		
		float totalPrice = 0.0f;
		
		for (int i=0; i<item.size(); i++){
			
			totalPrice += this.item.get(i).getPrice() * this.itemQuantity.get(i);
			
		}
		
		return totalPrice;
	}
	
}
