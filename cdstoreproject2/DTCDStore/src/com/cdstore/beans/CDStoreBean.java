package com.cdstore.beans;

import com.cdstore.catalogservice.ProductCatalogServiceClient;
import com.cdstore.entities.Account;
import com.cdstore.entities.Category;
import com.cdstore.entities.CD;

public class CDStoreBean {

private ProductCatalogServiceClient productServiceClient;
	
	public CDStoreBean(){
	
		productServiceClient = new ProductCatalogServiceClient();
		
	}
	
	
	public Category[] getCategoryList(){
		
		//call service
		
      
		Category[] categories = productServiceClient.getServiceInterface().getCategoryList();
		
		
		return categories;
	}
	
	public CD[] getCDList(){
		
		//call service
		CD[] cds = productServiceClient.getServiceInterface().getCDListAll();
		
	
		
		  
		  return cds;
	}
	
	public CD[] getCDList(int categoryId){
		
		//call service
		CD[] cds = productServiceClient.getServiceInterface().getCDList(categoryId);
		
	
		  return cds;
	}
	
	public CD getCDInfo(Integer cdid){
		
		//call service
		CD cd = productServiceClient.getServiceInterface().getCDInfo(cdid);
	
		
		  return cd;
		
	}
//	public static void main(String[] args) throws Exception {
//		System.out.println("DAY.....");
//	  CDStoreBean data=new CDStoreBean();
 //      CD[] cds=data.getCDList();
//	  Category[] cds=data.getCategoryList();
//       // System.out.println(data.getUserName());
 //      for(CD cat:cds){
//        	System.out.println(cat.getCdid().toString()+" "+ cat.getTitle());
 //     }
//        
        
       // String icount=hello.getCDs();.
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
//   }

	
}


