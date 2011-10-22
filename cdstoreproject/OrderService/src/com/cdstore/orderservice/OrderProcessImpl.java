package com.cdstore.orderservice;

import com.cdstore.entities.*;
import com.cdstore.dbagent.*;


import javax.jws.WebService;

@WebService(endpointInterface = "com.cdstore.orderservice.OrderProcess")
public class OrderProcessImpl implements OrderProcess{
	
	private DBAgent DB;
	
	
	public OrderProcessImpl()
	{
		DB = new DBAgent();
	}
	
	@Override
	public Account getAccount(String username, String password)
	{
		Account A = new Account();
		try {
			A =  DB.getAccount(username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return A;
	}
	
	@Override
	public Account createAccount(Account in)
	{
		Account A = new Account();
		
		try {
			A = DB.createAccount(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return A;
	}
	
	@Override
	public Boolean confirmOrder(Order order)
	{
		Boolean A = false;
		
		try {
			A = DB.confirmOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return A;
	}
	
	@Override
	public void validateInput()
	{
		
	}

}
