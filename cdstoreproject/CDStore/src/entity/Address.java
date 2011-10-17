package entity;

public class Address {
	private Integer AddressID;
	private String Phone;
	private String Country;
	private String Province;
	private String Street;
	
	public Address(){
	
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
