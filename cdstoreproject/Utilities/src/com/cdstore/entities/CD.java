package com.cdstore.entities;

public class CD {
	
	Integer cdID;
	String title;
	Float price;
	Integer categoryID;
	String artist;	
	String label;
	
	public CD(){
	}
	public CD(Integer cdID, String title, Float price, Integer categoryID, String artist, String label){
		this.cdID=cdID;
		this.price=price;
		this.title=title;
		this.categoryID=categoryID;
		this.artist=artist;
		this.label=label;
	}
	public Integer getID(){
		return cdID;
	}
	public void setID(Integer cdID){
		this.cdID=cdID;
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
	public Float getPrice(){
		return this.price;
	}
	public void setPrice(Float price){
		this.price=price;
	}
	
}
