package com.cdstore.entity;

public class Category {
	Integer CategoryID;
	String CategoryName;
	public Category(){
		
	}
	public Category(Integer CategoryID,String CategoryName){
		this.CategoryID=CategoryID;
		this.CategoryName=CategoryName;
	}
	public Integer getCategoryID(){
		return this.CategoryID;
	}
	public void setCategoryID(Integer CategoryID){
		this.CategoryID=CategoryID;
	}
	
	public String getCategoryName(){
		return this.CategoryName;
	}
	public void setCategoryName(String categoryName){
		this.CategoryName=categoryName;
	}
	
}
