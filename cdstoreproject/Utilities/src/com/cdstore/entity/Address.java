package com.cdstore.entity;

public class Address {
	private Integer AddressID;
	private String Phone;
	private String Country;
	private String Province;
	private String Street;
	private String PostalCode;
	private String City;
	
	public Address(){
	
	}
	public Address(Integer addressID,String phone, String country,String province,String street,String postalCode,String city){
		this.AddressID=addressID;
		this.Phone=phone;
		this.Country=country;
		this.Province=province;
		this.Street=street;
		this.PostalCode=postalCode;
		this.City=city;
	}
	public String getCity(){
		return this.City;
	}
	public void setCity(String city){
		this.City=city;
	}
	public String getPostalCode(){
		return this.PostalCode;
	}
	public void setPostalCode(String postalCode){
		this.PostalCode=postalCode;
	}
	public Integer getAddressID(){
		return this.AddressID;
	}
	public void setAddressID(Integer AddressID){
		this.AddressID=AddressID;
	}
	public String getPhone(){
		return this.Phone;
	}
	public void setPhone(String Phone){
		this.Phone=Phone;
	}
	public String getCountry(){
		return this.Country;
	}
	public void setCountry(String Country){
		this.Country=Country;
	}
	public String getProvince(){
		return this.Province;
	}
	public void setProvince(String Province){
		this.Province=Province;
	}
	public String getStreet(){
		return this.Street;
	}
	public void setStreet(String Street){
		this.Street=Street;
	}
}
