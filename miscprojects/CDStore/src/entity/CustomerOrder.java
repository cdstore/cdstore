package entity;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerOrder {
	private Customer Customer;
	private String Status;
	private Date Dateordered;
	private BigDecimal Amount;
	private Integer POID;
	
	public Customer getCustomer(){
		return this.Customer;
	}
	public void setCustomer(Customer Customer){
		this.Customer=Customer;
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
