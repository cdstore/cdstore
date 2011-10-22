package com.cdstore.beans;

import java.util.Date;
import java.util.Random;

import com.cdstore.entities.Account;
import com.cdstore.entities.Order;
import com.cdstore.entities.OrderDetails;
import com.cdstore.orderservice.OrderProcessClient;
import com.cdstore.shoppingcart.ShoppingCart;
import com.cdstore.shoppingcart.ShoppingCartItem;

public class OrderBean {
	
	private Account account;
	private OrderProcessClient orderServiceClient;
	private Order order;
	private boolean orderStatus;
	
	
	public OrderBean(){
		orderServiceClient = new OrderProcessClient();
	}
	
	public Account getAccount(String username, String password){
			
		// account not null if previously retrieved from service
		
		// call service to retrieve user's account (checked for null in loginaction.jsp)
		//account = orderServiceClient.getServiceInterface().getAccount(username, password);
		
		
		//placeholder till can call service
		account = new Account();
		account.setUserName(username);
		account.setPassword(password);
	
		return account;
		
	}

	public Account createAccount(Account account) {
		Account serviceAccount = null; 
		
		// call service to retrieve user's account
		// serviceAccount = orderServiceClient.getServiceInterface().createAccount(account);
		
		if (serviceAccount != null) {
			this.account = serviceAccount;
		}
		
		return serviceAccount;
	}
		
	public Account getAccount(){
		return account;
	}
	
	public void createOrder(ShoppingCart shopCart){
		// call service to retrieve user's account
		// order = orderServiceClient.getServiceInterface().createOrder(shopCart, account);
				
		//placeholder stuff below
		order = new Order();
		order.setAccount(account);
		order.setAmount(shopCart.getTotalPrice());
		order.setDateOrdered(new Date());
		order.setOrderID(1);
		
		int shopCartSize = shopCart.getSize();
		
		OrderDetails[] details = new OrderDetails[shopCartSize];
		
		for (int i=0;i<shopCartSize;i++){
			details[i] = new OrderDetails();
			
			ShoppingCartItem shopItem = shopCart.getItemFromIndex(i);
			
			details[i].setCDID(shopItem.getID());
			details[i].setOrderID(1);	//belongs to order 1
			details[i].setPrice(shopItem.getPrice());
			details[i].setQuantity(shopCart.getQuantityByIndex(i));			
		}
		
		order.setOrderDetails(details);
	}

	public Order getOrder() {
		return order;
	}
	
	public boolean confirmOrder(String ccNumber, String secNumber) {
		
		//pretending called imaginary CC service that returns confirmation code
		Random rndgen = new Random();
        int paymentInfo = rndgen.nextInt(999999) + 100000;
		        
		if (ccNumber == "error" || secNumber == "error"){
			//orderStatus = orderServiceClient.getServiceInterface().confirmOrder(-1);
		} else {
			//orderStatus = orderServiceClient.getServiceInterface().confirmOrder(paymentInfo);
		}
		
		//placeholder
		orderStatus = true;
		
		return orderStatus;
	}
	
	public void removeLocalOrder(){
		order = null;
	}
	
}
