package com.cdstore.orderservice;
import com.cdstore.entities.*;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Order Webservice interface class
 * @author Chris
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)

public interface OrderProcess {
	
	Account getAccount(String username, String password);
	Account createAccount(Account in);
	Boolean confirmOrder (Order order);
	void validateInput();
	
}
