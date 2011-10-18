package entity;

import java.math.BigDecimal;
import java.util.Collection;

public class Cds {
	BigDecimal Price;
	Collection<OrderDetails> OrderedCds;
	public Cds(){
		
	}
	public Cds(Integer CdID,BigDecimal Price, String Title,Integer CategoryID){
		this.CdID=CdID;
		this.Price=Price;
		this.Title=Title;
		this.CategoryID=CategoryID;
	}
	Integer CdID;
	public Integer getid(){
		return CdID;
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
