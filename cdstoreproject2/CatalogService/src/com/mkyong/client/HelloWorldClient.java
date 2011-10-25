package com.mkyong.client;

import java.net.URL;
import java.util.ArrayList;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.cdstore.catalogservice.ProductCatalog;
import com.cdstore.entities.CD;
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
        for(Category cat:data){
        	System.out.println(cat.getCategoryID().toString()+" "+ cat.getCategoryName());
        }
        
//        CD[] cds=hello.getCDList();
//        for(CD cd:cds){
//        	System.out.println(cd.getTitle());
//        }
//        
//        System.out.println("---");
//        
//        CD[] cds2 = hello.getCDListByCategory(4);
//        for(CD cd2:cds2){
//        	System.out.println(cd2.getTitle());
//        }
        
        
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
