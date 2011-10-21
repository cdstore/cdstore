package com.cdstore.orderservice;
import com.cdstore.entity.*;
import java.sql.*;

public interface OrderProcess {
	
	Account getAccount(String username, String password) throws SQLException;
	Account createAccount(Account in) throws SQLException;
	Boolean confirmOrder(ShoppingCart cart, Order order) throws SQLException;
	void validateInput();
	
}
