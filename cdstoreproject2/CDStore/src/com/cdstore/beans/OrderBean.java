package com.cdstore.beans;

import java.util.List;
import java.util.Random;

import com.cdstore.entities.*;
import com.cdstore.orderservice.OrderProcessServiceClient;
import com.cdstore.shoppingcart.ShoppingCart;
import com.cdstore.shoppingcart.ShoppingCartItem;

public class OrderBean {
	
	private Account account;
	private OrderProcessServiceClient orderServiceClient;
	private Order order;
	private boolean orderStatus;
	
	
	public OrderBean(){
		orderServiceClient = new OrderProcessServiceClient();
	}
	/***
	 * Retrieve account information from the webservice when user logs in
	 * @param username
	 * @param password
	 * @return
	 */
	public Account getAccount(String username, String password){
			
		// account not null if previously retrieved from service
		
		// call service to retrieve user's account (checked for null in loginaction.jsp)
		account = orderServiceClient.getServiceInterface().getAccount(username, password);
		
	
		return account;
		
	}
	public void setAccount(Account account){
		this.account=account;
	}
	/**
	 * Creates a new user account by submitting the information to the web service
	 * @param account
	 * @return
	 */
	public Account createAccount(Account account) {
		Account serviceAccount = null; 
		
		// call service to retrieve user's account
		 serviceAccount = orderServiceClient.getServiceInterface().createAccount(account);
		
		if (serviceAccount != null) {
			this.account = serviceAccount;
		}
		
		return serviceAccount;
	}
		
	public Account getAccount(){
		return account;
	}
	/**
	 * Creates and ordder from shopping cart information and user account information
	 * @param shopCart
	 */
	public void createOrder(ShoppingCart shopCart){
		order = new Order();
		order.setAccount(account);
		int shopCartSize = shopCart.getItems().size();
		order.setAmount(shopCart.getTotal());
		order.setStatus("ORDERED");
		OrderDetails[] details = new OrderDetails[shopCartSize];
		
		int i=0;
		List<ShoppingCartItem> items=shopCart.getItems();
		for(ShoppingCartItem cartItem:items){
			OrderDetails detail=new OrderDetails();
			detail.setCDID(cartItem.getCdid());
			detail.setOrderID(0);
			detail.setPrice(cartItem.getPrice());
			detail.setQuantity(cartItem.getQuantity());
			details[i]=detail;
			i++;
		}
		
		order.setOrderDetails(details);
	}

	public Order getOrder() {
		return order;
	}
	/**
	 * This Function Takes the Order Information and Credit Card Information validate against an imaginary credit system
	 * and submits submits it to the webservice to be persisted
	 * @param order	- Order That need to to persisted in the Database
	 * @param ccNumber - Credit Card Number
	 * @param secNumber - Credit Card Security Number
	 * @return Boolean
	 */
	public boolean confirmOrder(Order order,String ccNumber, String secNumber) {
		
		//pretending called imaginary CC service that returns confirmation code
		Random rndgen = new Random();
        int paymentInfo = rndgen.nextInt(999999) + 100000;
		        
		if (ccNumber == "error" || secNumber == "error"){
			//orderStatus = orderServiceClient.getServiceInterface().confirmOrder(-1);
			orderStatus=false;
		} else {
			orderStatus=orderServiceClient.getServiceInterface().confirmOrder(order);
		}
		
		return orderStatus;
	}
	
public void removeLocalOrder(){
	this.order=null;
}
	public static void main(String[] args) throws Exception {
//	System.out.println("DAY.....");
//		Order order=new Order();
//		Account account=new Account();
//		account.setFirstName("Daniel");
//		account.setLastName("Antwi");
//		account.setLastName("nss");
//		account.setUserName("test");
//		Address add=new Address();
//		add.setAddressID(1);
//		add.setCity("ottawa");
//		add.setPhone("02342343");
//		account.setAddress(add);
//		order.setAccount(account);
//		Double dt= 80.00;
//		order.setAmount(dt);
//		order.setStatus("PROCESSED");
//		OrderDetails od=new OrderDetails();
//		od.setCDID(1);
//		od.setOrderID(0);
//		od.setPrice(11.3);
//		od.setQuantity(2);
//		OrderDetails[] ods=new OrderDetails[1];
//		ods[0]=od;
//		order.setOrderDetails(ods);
//		
		OrderBean oBean=new OrderBean();
//	    String result=oBean.orderServiceClient.getServiceInterface().confirmOrderT(order);
//		System.out.println(result);
		 Account  acct=new Account();
	//	 acct=oBean.getAccount("test", "tt");
//		 	Boolean b=oBean.confirmOrder(order, "2234", "99");
//		    if(b==false)
//		    {
//				System.out.println("HelloNO NO NO");
//		    }else
//		    {
//		    	System.out.println(acct.getUserName());
//		    }
//   for(CD cat:cds){
//    	System.out.println(cat.getCategoryID().toString()+" "+ cat.getTitle());
//    }
//    
    
   // String icount=hello.getCDs();.
   // System.out.print(icount);
    //System.out.println(Data);
   // List<Category> data=(List<Category>) hello.getCDs();
//    Integer i=0;
//    Iterator<Category> iterator=data.iterator();
//    System.out.println(data.size());
//    while(iterator.hasNext()){
//    	i++;
//    	Category cat=iterator.next();
//    	System.out.println(cat.getCategoryName()+i.toString());
//    }
}	
	
}
