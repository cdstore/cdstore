package entity;

import java.util.Collection;

public class Account {
	private String FirstName;
	private String LastName;
	private String UserName;
	private String Password;
	Collection<Address> CustomerAddress;
	
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
	public Collection<Address> getCustomers(){
		return this.CustomerAddress;
	}
	public void setCustomers(Collection<Address> CustomerAddress){
		this.CustomerAddress=CustomerAddress;
	}
}
