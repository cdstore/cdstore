package com.cdstore.orderservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
/**
 * Order Webservice client interface. All methods will call the order webservice through this class
 * @author Chris
 *
 */
public class OrderProcessServiceClient {

	private OrderProcess oProcessIF;
	
	public OrderProcessServiceClient() {
		System.setProperty("javax.net.ssl.trustStore", System.getenv("TOMCAT_HOME")+"/conf/keystore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "asdasd");
		URL url = null;
		
		try {
			url = new URL("https://localhost:8443/OrderService/order?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        QName qname = new QName("http://orderservice.cdstore.com/", "OrderProcessImplService");
        		

        Service service = Service.create(url, qname);

        oProcessIF = service.getPort(OrderProcess.class);
	}
	
	
	// OrderBean will call methods from service through this interface
		public OrderProcess getServiceInterface(){
		return oProcessIF;
	}
	
}
