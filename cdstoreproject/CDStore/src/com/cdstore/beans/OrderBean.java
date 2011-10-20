package com.cdstore.beans;

import com.cdstore.entities.Account;
import com.cdstore.services.clients.OrderProcessClient;

public class OrderBean {
	
	private Account account;
	private OrderProcessClient orderServiceClient;
	
	public OrderBean(){
		orderServiceClient = new OrderProcessClient();
	}
	
	public Account getAccount(String username, String password){
			
		// account not null if previously retrieved from service
		
		// call service to retrieve user's account (checked for null in loginaction.jsp)
		// account = orderServiceClient.getServiceInterface().getAccount(username, password);
		
		
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
}
