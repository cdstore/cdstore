package com.cdstore.beans;

import com.cdstore.entities.Category;
import com.cdstore.entities.CD;
import com.cdstore.services.clients.ProductCatalogServiceClient;

public class CDStoreBean {

	private ProductCatalogServiceClient productServiceClient;
	
	public CDStoreBean(){
	
		productServiceClient = new ProductCatalogServiceClient();
		
	}
	
	public Category[] getCategoryList(){
		
		//call service
		//Category[] categories = productServiceClient.getServiceInterface().getCategoryList();
		
		//placeholder array data
		
		Category[] categories = new Category[3];
		
		categories[0] = new Category();
		categories[0].setCategoryName("Rock");
		categories[0].setCategoryID(0);
		
		categories[1] = new Category();
		categories[1].setCategoryName("Pop");
		categories[1].setCategoryID(1);
		
		categories[2] = new Category();
		categories[2].setCategoryName("Country");
		categories[2].setCategoryID(2);
		
		return categories;
	}
	
	public CD[] getCDList(){
		
		//call service
		//Cds[] cds = productServiceClient.getServiceInterface().getCDList();
		
		
		//placeholder array data
		
		CD[] cds = new CD[5];
		
		cds[0] = new CD();
		cds[0].setTitle("Title0");
		cds[0].setPrice(new Float(10.0));		
		cds[0].setCategoryID(0);
		cds[0].setID(0);

		cds[1] = new CD();
		cds[1].setTitle("Title1");
		cds[1].setPrice(new Float(11.0));		
		cds[1].setCategoryID(1);
		cds[1].setID(1);
		
		cds[2] = new CD();
		cds[2].setTitle("Title2");
		cds[2].setPrice(new Float(12.0));		
		cds[2].setCategoryID(2);
		cds[2].setID(2);

		cds[3] = new CD();
		cds[3].setTitle("Title3");
		cds[3].setPrice(new Float(13.0));		
		cds[3].setCategoryID(0);
		cds[3].setID(3);
		
		cds[4] = new CD();
		cds[4].setTitle("Title4");
		cds[4].setPrice(new Float(14.0));		
		cds[4].setCategoryID(1);
		cds[4].setID(4);
		
		return cds;
	}
	
	public CD[] getCDList(int categoryId){
		
		//call service
		//Cds[] cds = productServiceClient.getServiceInterface().getCDList(categoryId);
		
		
		//placeholder array data
		
		CD[] cds;
		
		if (categoryId == 0) {
			cds = new CD[2];
			
			cds[0] = new CD();
			cds[0].setTitle("Title0");
			cds[0].setPrice(new Float(10.0));		
			cds[0].setCategoryID(0);
			cds[0].setID(0);

			cds[1] = new CD();
			cds[1].setTitle("Title3");
			cds[1].setPrice(new Float(13.0));		
			cds[1].setCategoryID(0);
			cds[1].setID(3);
		} else if (categoryId == 1) {
			cds = new CD[2];
			
			cds[0] = new CD();
			cds[0].setTitle("Title1");
			cds[0].setPrice(new Float(11.0));		
			cds[0].setCategoryID(1);
			cds[0].setID(1);
			
			cds[1] = new CD();
			cds[1].setTitle("Title4");
			cds[1].setPrice(new Float(14.0));		
			cds[1].setCategoryID(1);
			cds[1].setID(4);
		} else {
			cds = new CD[1];
			
			cds[0] = new CD();
			cds[0].setTitle("Title2");
			cds[0].setPrice(new Float(12.0));		
			cds[0].setCategoryID(2);
			cds[0].setID(2);	
		}
		
		return cds;
	}
	
	
}
