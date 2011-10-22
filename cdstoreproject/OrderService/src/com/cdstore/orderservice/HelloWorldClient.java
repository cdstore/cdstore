package com.cdstore.orderservice;

import java.net.URL;
import java.util.ArrayList;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cdstore.entities.*;



public class HelloWorldClient{
	
	public static void main(String[] args) throws Exception {
		System.out.println("DAY.....");
		URL url = new URL("http://localhost:8080/OrderService/order?wsdl");
        QName qname = new QName("http://orderservice.cdstore.com/", "OrderProcessImplService");
        System.out.println("DAY.....");
        Service service = Service.create(url, qname);
       // ArrayList<Category> data=new ArrayList<Category>();
        OrderProcess hello = service.getPort(OrderProcess.class);
        System.out.println("Start");
        Account data=hello.getAccount("test", "test");
        	System.out.println(data.getFirstName() + " " + data.getLastName());
        
        
        
       // String icount=hello.getCDs();
       // System.out.print(icount);
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
