/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cdstore.shoppingcart;

import com.cdstore.entities.*;

/**
 *
 * @author tgiunipero
 */
public class ShoppingCartItem {

	private Double amount;
   private  CD cd;
   private Integer quantity;
   private String title;
   private Double price;
   private Integer cdid;
    public ShoppingCartItem(CD cd) {
        this.cd = cd;
        this.title=cd.getTitle();
        this.price=cd.getPrice();
        this.cdid=cd.getID();
        quantity = 1;
    }
    public String getTitle(){
    	return this.title;
    }
    public Double getPrice(){
    	return this.price;
    }
    public void setTitle(String title){
    	this.title=title;
    }
    public void setCdid(Integer cdid){
    	this.cdid=cdid;
    }
    public Integer getCdid(){
    	return this.cdid;
    }
    public CD getCD() {
        return cd;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }
    public Double getAmount(){
    	return this.amount;
    }
    public void setAmount(){
    	 amount = (this.getQuantity() * cd.getPrice());
    }
    public double getTotal() {
    	double amt;
        amt = (this.getQuantity() * cd.getPrice().doubleValue());
        return amt;
    }

}