package com.cdstore.entities;
/**
 * Category Entity Object for Category Information
 * @author Nicedan
 *
 */
public class Category {
	private Integer categoryID;
	private String categoryName;
	
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
