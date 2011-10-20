package com.cdstore.entities;

import com.cdstore.shoppingcart.ShoppingCartItem;

public class CD extends ShoppingCartItem {
	
	// id and price are inherited from ShoppingCartItem
	private String title;
	private Integer categoryID;
	private String artist;	
	private String label;
	
	public CD(){
	}
	public CD(Integer id, String title, Float price, Integer categoryID, String artist, String label){
		this.id=id;
		this.price=price;
		this.title=title;
		this.categoryID=categoryID;
		this.artist=artist;
		this.label=label;
	}
	public String getArtist(){
		return this.artist;
	}
	public void setArtist(String artist){
		this.artist=artist;
	}
	public String getLabel(){
		return this.label;
	}
	public void setLabel(String label){
		this.label=label;
	}
	public Integer getCategoryID(){
		return this.categoryID;
	}
	public void setCategoryID(Integer categoryID){
		this.categoryID=categoryID;
	}
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	
}
