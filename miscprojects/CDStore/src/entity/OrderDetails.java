package entity;



public class OrderDetails {
	
	private Integer CdID;
	private Integer POID;
	private Integer Quantity;
	private Cds Cds;
	private CustomerOrder CustomerOrder;
	public OrderDetails(){
		
	}
	
	public OrderDetails(Integer CdID,Integer POID){
		this.CdID=CdID;
		this.POID=POID;
	}
	
	public Integer getCdID(){
		return this.CdID;
	}
	public void setCdID(Integer CdID){
		this.CdID=CdID;
	}
	public Integer getPOID(){
		return this.POID;
	}
	public void setPOID(Integer POID){
		this.POID=POID;
	}
	public Integer getQuantity(){
		return this.Quantity;
	}
	public void setQuantity(Integer Quantity){
		this.Quantity=Quantity;
	}
	public Cds getCds(){
		return this.Cds;
	}
	public void setCds(Cds Cds){
		this.Cds=Cds;
	}
	public CustomerOrder getCustomerOrder(){
		return this.CustomerOrder;
	}
	public void setCustomerOrder(CustomerOrder CustomerOrder){
		this.CustomerOrder=CustomerOrder;
	}
}

