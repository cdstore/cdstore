package com.cdstore.orderservice;

import com.cdstore.entities.*;
import com.cdstore.shoppingcart.*;
import com.cdstore.dbagent.*;
import java.sql.*;

public class OrderProcessImpl implements OrderProcess{
	
	private DBAgent DB;
	
	public OrderProcessImpl()
	{
		DB = new DBAgent();
	}
	
	public Account getAccount(String username, String password) throws SQLException
	{
		return DB.getAccount(username,password);
	}
	public Account createAccount(Account in) throws SQLException
	{
		return DB.createAccount(in);
	}
	
	public Boolean confirmOrder(ShoppingCart cart, Order order) throws SQLException
	{
		return DB.confirmOrder(cart,order);
	}
	
	public void validateInput()
	{
		
	}

}
