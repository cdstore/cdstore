package com.cdstore.entities;

public class Category {
	Integer categoryID;
	String categoryName;
	
	public Category(){
		
	}
	
	public Category(Integer categoryID, String categoryName){
		this.categoryID=categoryID;
		this.categoryName=categoryName;
	}
	
	public Integer getCategoryID(){
		return this.categoryID;
	}
	
	public void setCategoryID(Integer categoryID){
		this.categoryID=categoryID;
	}
	
	public String getCategoryName(){
		return this.categoryName;
	}
	
	public void setCategoryName(String categoryName){
		this.categoryName=categoryName;
	}
	
}