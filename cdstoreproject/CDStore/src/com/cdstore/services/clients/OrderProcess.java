package com.cdstore.services.clients;
import com.cdstore.entities.*;
import com.cdstore.shoppingcart.*;
import java.sql.*;

public interface OrderProcess {
	
	Account getAccount(String username, String password) throws SQLException;
	Account createAccount(Account in) throws SQLException;
	Boolean confirmOrder(ShoppingCart cart, Order order) throws SQLException;
	void validateInput();
	
}
