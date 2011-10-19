package com.cdstore.entity;

import java.math.BigDecimal;
import java.util.Collection;



public class Cds {
	BigDecimal Price;
	Collection<OrderDetails> OrderedCds;
	String Artist;
	String Label;
	public Cds(){
		
	}
	public Cds(Integer CdID, String Title,BigDecimal Price,Integer CategoryID,String artist,String label){
		this.CdID=CdID;
		this.Price=Price;
		this.Title=Title;
		this.CategoryID=CategoryID;
		this.Artist=artist;
		this.Label=label;
	}
	Integer CdID;
	public Integer getid(){
		return CdID;
	}
	public String getArtist(){
		return this.Artist;
	}
	public void setArtist(String artist){
		this.Artist=artist;
	}
	public String getLabel(){
		return this.Label;
	}
	public void setLabel(String label){
		this.Label=label;
	}
	public void setid(Integer CdID){
		this.CdID=CdID;
	}
	Integer CategoryID;
	public Integer getCategoryID(){
		return this.CategoryID;
	}
	public void setCategoryID(Integer CategoryID){
		this.CategoryID=CategoryID;
	}
	String Title;
	public String getTitle(){
		return this.Title;
	}
	public void setTitle(String Title){
		this.Title=Title;
	}
	public BigDecimal getPrice(){
		return this.Price;
	}
	public void setPrice(BigDecimal price){
		this.Price=price;
	}
	
	 public Collection<OrderDetails> OrderedCds(){
		 return this.OrderedCds;
	 }
	public void setOrderedCds(Collection<OrderDetails> OrderedCds){
		this.OrderedCds=OrderedCds;
	}
	
	
}
