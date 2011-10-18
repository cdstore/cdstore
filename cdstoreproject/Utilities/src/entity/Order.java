package entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private Account Account;
	private String Status;
	private Date Dateordered;
	private BigDecimal Amount;
	private Integer POID;
	
	public Account getCustomer(){
		return this.Account;
	}
	public void setCustomer(Account Account){
		this.Account=Account;
	}
	public String getStatus(){
		return this.Status;
	}
	public void setStatus(String Status){
		this.Status=Status;
	}
	public  Date getDateordered(){
		return this.Dateordered;
	}
	public void getDateOrdered(Date Dateordered){
		this.Dateordered=Dateordered;
	}
	public BigDecimal getAmount(){
		return this.Amount;
	}
	public void setAmount(BigDecimal Amount){
		this.Amount=Amount;
	}
	public Integer getPOID(){
		return this.POID;
	}
	public void setPOID(Integer POID){
		this.POID=POID;
	}
}
