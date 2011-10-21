package com.mkyong.client;

import java.net.URL;
import java.util.ArrayList;



//import entity.*;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cdstore.catalogservice.ProductCatalog;
import com.cdstore.entities.Category;



public class HelloWorldClient{
	
	public static void main(String[] args) throws Exception {
		System.out.println("DAY.....");
		URL url = new URL("http://localhost:8080/ProductCatalog/catalog?wsdl");
        QName qname = new QName("http://catalogservice.cdstore.com/", "ProductCatalogImplService");
        System.out.println("DAY.....");
        Service service = Service.create(url, qname);
       // ArrayList<Category> data=new ArrayList<Category>();
        ProductCatalog hello = service.getPort(ProductCatalog.class);
        System.out.println("Start");
        Category[] data=hello.getCategoryList();
        Category cat=data[0];
        System.out.println(cat.getCategoryName());
        
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
