package com.cdstore.entities;

public class Account {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Address address;
	
	public Account() {
	}
	public Account(String firstName, String lastName, String userName, String password, Address address){
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.address=address;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public Address getAddress(){
		return this.address;
	}
	public void setAddress(Address address){
		this.address=address;
	}
}
