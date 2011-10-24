package com.cdstore.entities;

//import com.cdstore.shoppingcart.ShoppingCartItem;

public class CD {
	
	// id and price are inherited from ShoppingCartItem
	private String title;
	private Integer categoryID;
	private String artist;	
	private String label;
	private Integer cdid;
	private Double price;
	private Integer id;
	
	public CD(){
	}
	public CD(Integer id, String title, Double price, Integer categoryID, String artist, String label){
		this.cdid=id;
		this.price=price;
		this.title=title;
		this.categoryID=categoryID;
		this.artist=artist;
		this.label=label;
		this.id=id;
	}
	public void setPrice(Double price){
		this.price=price;
	}
	public Double getPrice(){
		return this.price;
	}
	public void setID(Integer id){
		this.id=id;
	}
	public Integer getID(){
		return this.id;
	}
	public void setCdid(Integer cdid){
		this.cdid=cdid;
	}
	public Integer getCdid(){
		return this.cdid;
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
