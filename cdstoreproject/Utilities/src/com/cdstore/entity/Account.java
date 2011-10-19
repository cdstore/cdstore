package com.cdstore.entity;



public class Account {
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	private Address Address;
	
	public String getFirstName(){
		return this.FirstName;
	}
	public void setFirstName(String FirstName){
		this.FirstName=FirstName;
	}
	public String getLastName(){
		return this.LastName;
	}
	public void setLastName(String LastName){
		this.LastName=LastName;
	}
	public String getUserName(){
		return this.UserName;
	}
	public void setUserName(String UserName){
		this.UserName=UserName;
	}
	public String getPassword(){
		return this.Password;
	}
	public void setPassword(String Password){
		this.Password=Password;
	}
	public Address getAddress(){
		return this.Address;
	}
	public void setAddresses(Address Address){
		this.Address=Address;
	}
}
