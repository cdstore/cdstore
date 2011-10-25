package com.cdstore.orderservice;

import java.net.URL;
import java.util.ArrayList;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

//import com.cdstore.beans.OrderBean;
import com.cdstore.entities.*;



public class HelloWorldClient{
//	static {
//	    //for localhost testing only
//	    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
//	    new javax.net.ssl.HostnameVerifier(){
// 
//	        public boolean verify(String hostname,
//	                javax.net.ssl.SSLSession sslSession) {
//	            if (hostname.equals("localhost")) {
//	                return true;
//	            }
//	            return false;
//	        }
//	    });
//	}

	public static void main(String[] args) throws Exception {
		System.out.println("DAY.....");
		System.setProperty("javax.net.ssl.trustStore", System.getenv("TOMCAT_HOME")+"/conf/keystore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "asdasd");
		URL url = new URL("https://localhost:8443/OrderService/order?wsdl");
        QName qname = new QName("http://orderservice.cdstore.com/", "OrderProcessImplService");
        System.out.println("DAY.....");
        Service service = Service.create(url, qname);
       // ArrayList<Category> data=new ArrayList<Category>();
        OrderProcess hello = service.getPort(OrderProcess.class);
        System.out.println("Start");
        Account data=hello.getAccount("test", "test");
        	System.out.println(data.getFirstName() + " " + data.getLastName()+System.getenv("TOMCAT_HOME"));
//        
//        Order order=new Order();
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
//		order.setStatus("ORDERED");
//		OrderDetails od=new OrderDetails();
//		od.setCDID(1);
//		od.setOrderID(0);
//		od.setPrice(11.3);
//		od.setQuantity(2);
//		
//		OrderDetails[] ods=new OrderDetails[1];
//		ods[0]=od;
//		order.setOrderDetails(ods);
//		
	//	Boolean Result=hello.confirmOrder(order);
        //OrderDetails[] rods=order.getOrderDetails();
        //OrderDetails ss=rods[0];
       // Result=ods[0].getCDID().toString();
//       for(OrderDetails dd:rods){
//    	   Result+=dd.getCDID();
//    	   Result+=dd.getOrderID();
//    	   Result+=dd.getPrice();
//    	   Result+=dd.getQuantity();
//       }
//      
       // String icount=hello.getCDs();
  //     System.out.println(Result);
        //System.out.println(Data);
       // List<Category> data=(List<Category>) hello.getCDs();
//        Integer i=0;
//        Iterator<Category> iterator=data.iterator();
//        System.out.println(data.size());
//        while(iterator.hasNext()){
//        	i++;
//        	Category cat=iterator.next();
//        	System.out.println(cat.getCategoryName()+i.toString());
//        }
    }

}
