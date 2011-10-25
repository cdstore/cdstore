package com.cdstore.entities;
/**
 * Address Entity Object for Address Information
 * @author Nicedan
 *
 */
public class Address {
	private Integer addressID;
	private String phone;
	private String country;
	private String province;
	private String street;
	private String postalCode;
	private String city;
	
	public Address() {
	}
	public Address(Integer addressID, String phone, String country, String province, String street, String postalCode, String city){
		this.addressID=addressID;
		this.phone=phone;
		this.country=country;
		this.province=province;
		this.street=street;
		this.postalCode=postalCode;
		this.city=city;
	}
	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city=city;
	}
	public String getPostalCode(){
		return this.postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode=postalCode;
	}
	public Integer getAddressID(){
		return this.addressID;
	}
	public void setAddressID(Integer addressID){
		this.addressID=addressID;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country=country;
	}
	public String getProvince(){
		return this.province;
	}
	public void setProvince(String province){
		this.province=province;
	}
	public String getStreet(){
		return this.street;
	}
	public void setStreet(String street){
		this.street=street;
	}
}
